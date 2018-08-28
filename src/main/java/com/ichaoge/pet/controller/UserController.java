package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.service.iservice.UserServiceI;
import com.ichaoge.pet.utils.HttpClientUtil;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by chaoge on 2018/8/27.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private UserServiceI userServiceI;

//    /**
//     * 登录
//     *
//     * @param request
//     * @return 查询结果信息
//     */
//    @RequestMapping(value = "/wxLogin", method = RequestMethod.POST)
//    @ResponseBody
//    public RemoteResult<?> login(HttpServletRequest request, @RequestBody UserParam param) {
//        String appid = "wx216e84db512d7ab5";
//        String secret = "7d983f1bdbdf345deed336515c392843";
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+param.getCode()+"&grant_type=authorization_code";
//        logger.info("请求地址：" + request.getRequestURI() + "  " + "请求参数：" + param + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
//        User user = null;
//        String result = HttpClientUtil.doGet(url);
//        //开始查询
//        try {
//            List<User> users = userServiceI.selectByExample(param);
//            if(users.size()>0){
//                user = users.get(0);
//            }
//            logger.info("应答参数：" + user + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
//        } catch (Exception e) {
//            logger.error("查询发生未知错误!", e);
//            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
//                    "查询发生未知错误!", null);
//        }
//        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),
//                ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), user);
//    }

    /**
     * 详细
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryItem", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryItem(HttpServletRequest request, @RequestBody UserParam param) {
        logger.info("请求地址：" + request.getRequestURI() + "  " + "请求参数：" + param.toString() + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        List<User> Users;
        //开始查询
        try {
            Users = userServiceI.selectByExample(param);
            logger.info("应答参数：" + Users.size() + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
                    "查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),
                ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), Users);
    }


}
