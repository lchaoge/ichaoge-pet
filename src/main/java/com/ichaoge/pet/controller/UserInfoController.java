package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.entity.UserInfo;
import com.ichaoge.pet.domain.inputParam.UserInfoParam;
import com.ichaoge.pet.service.iservice.UserInfoServiceI;
import com.ichaoge.pet.service.iservice.UserServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chaoge on 2018/8/28.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/userInfo")
public class UserInfoController extends BaseController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private UserServiceI userServiceI;
    @Resource
    private UserInfoServiceI userInfoServiceI;

    /**
     * 修改用户详细信息
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryItem(HttpServletRequest request, @RequestBody UserInfoParam param) {
        logger.info("请求地址：" + request.getRequestURI() + "  " + "请求参数：" + param.toString() + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        User currentUser = null;
        //开始查询
        try {
            User user = new User();
            user.setId(param.getUserId());
            user.setPhoto(param.getPhoto());
            user.setNickName(param.getNickName());
            user.setModified(new Date());
            int resultUser = userServiceI.updateByPrimaryKeySelective(user);
            if(resultUser == 1){
                logger.error("修改成功!");
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(param.getUserId());
                userInfo.setAddress(param.getAddress());
                userInfo.setSex(param.getSex());
                userInfo.setModified(new Date());
                int result = userInfoServiceI.updateByUserId(userInfo);
                if(result == 1){
                    logger.error("修改成功!");
                    currentUser = userServiceI.selectByPrimaryKey(user.getId());
                    if(currentUser == null){
                        return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
                                "查询用户失败!", currentUser);
                    }
                }else{
                    return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
                            "修改失败!", currentUser);
                }
            }else{
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
                        "修改失败!", currentUser);
            }
            logger.info("应答参数：" + resultUser + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
                    "查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),
                ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), currentUser);
    }


}
