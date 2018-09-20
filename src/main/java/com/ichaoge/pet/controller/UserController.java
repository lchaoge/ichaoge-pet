package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.entity.UserInfo;
import com.ichaoge.pet.domain.inputParam.DecodeParam;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.service.iservice.PetServiceI;
import com.ichaoge.pet.service.iservice.UserInfoServiceI;
import com.ichaoge.pet.service.iservice.UserServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import net.sf.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.spec.AlgorithmParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;

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
    @Resource
    private UserInfoServiceI userInfoServiceI;
    @Resource
    private PetServiceI petServiceI;

    /**
     * 分页查询
     *
     * @param param
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryAllPage", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryAllPage(HttpServletRequest request, @RequestBody UserParam param) {
        logger.info("请求地址：" + request.getRequestURI() + "  " + "请求参数：" + param.toString() + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        Pagination pagination = null;
        //开始查询
        try {
            pagination = userServiceI.queryAllPage(param);
            if(pagination == null){
                logger.error("没用查询到数据!");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"没用查询到数据!", null);
            }
            logger.info("应答参数：" + pagination + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询当前用户错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询当前用户错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(), ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), pagination);
    }


    /**
     * 登录
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/wxLogin", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> wxLogin(HttpServletRequest request, @RequestBody String code) {
        logger.info("请求地址：" + request.getRequestURI() + "  " + "请求参数：" + code + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        Map<String,Object> results = new HashMap<String,Object>();
        User loginUser = null;
        String resultJson = userServiceI.selectByCode(code);
        JSONObject jsonObject=JSONObject.fromObject(resultJson);
        String session_key = jsonObject.get("session_key").toString();
        String openid = jsonObject.get("openid").toString();
        //开始查询
        try {
            UserParam param = new UserParam();
            param.setOpenid(openid);
            param.setSessionKey(session_key);
            List<User> users = userServiceI.selectByExample(param);
            if(users.size()>0){
                loginUser = users.get(0);
            }else{
                User insertUser = new User();
                insertUser.setOpenid(openid);
                insertUser.setNickName("铲屎官_"+openid.substring(0,8));
                insertUser.setCreated(new Date());
                insertUser.setModified(new Date());
                int result = userServiceI.insertSelective(insertUser);
                if(result == 1){
                    // 注册成功
                    logger.error("注册成功！");
                    loginUser = userServiceI.selectByExample(param).get(0);
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUserId(loginUser.getId());
                    userInfo.setCreated(new Date());
                    userInfo.setModified(new Date());
                    int userInfoResult = userInfoServiceI.insert(userInfo);
                    if(userInfoResult == 1){
                        logger.error("注册成功！");
                    }else{
                        logger.error("注册失败!");
                    }
                }else{
                    logger.error("注册失败!");
                    return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
                            "注册失败!", null);
                }

            }
            Pet petParam = new Pet();
            petParam.setUserId(loginUser.getId());
            List<Pet> petList = petServiceI.selectByExample(petParam);
            Pet pet = null;
            for (int i = 0;i<petList.size();i++){
                if(petList.get(i).getIsCurrent().equals(1)){
                    pet = petList.get(i);
                    break;
                }
            }
            results.put("loginUser",loginUser);
            results.put("loginPet",pet);
            logger.info("应答参数：" + results + ",sessionid:" + request.getSession().getId() + ",用户：" + getUser());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
                    "查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), results);
    }

    /**
     * 根据ID查询用户
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryById(HttpServletRequest request, @RequestBody User param) {
        logger.info("请求地址：" + request.getRequestURI() + "  " + "请求参数：" + param.toString() + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        User currentUser = null;
        //开始查询
        try {
            currentUser = userServiceI.selectByPrimaryKey(param.getId());
            if(currentUser == null){
                logger.error("没用查询到用户!");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"没用查询到用户!", null);
            }
            logger.info("应答参数：" + currentUser + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询当前用户错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询当前用户错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(), ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), currentUser);
    }

    /**
     * 解密并且获取用户手机号码
     * @param param
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/decode", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> decode(HttpServletRequest request, @RequestBody DecodeParam param) {
        User currentUser = null;
        if(param.getCode() == ""){
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"微信code不能为空!", null);
        }
        try {
            String resultJson = userServiceI.selectByCode(param.getCode());
            JSONObject jsonObject=JSONObject.fromObject(resultJson);
            String session_key = jsonObject.get("session_key").toString();

            byte[] encrypData = Base64.decodeBase64(param.getEncrypdata());
            byte[] ivData = Base64.decodeBase64(param.getIvdata());
            byte[] sessionKey = Base64.decodeBase64(session_key);

            String str = userServiceI.decrypt(sessionKey,ivData,encrypData);
            JSONObject jsonResult = JSONObject.fromObject(str);

            // 获取用户
            currentUser = userServiceI.selectByPrimaryKey(param.getUserId());
            currentUser.setSessionKey(session_key);
            currentUser.setPhone(jsonResult.get("phoneNumber").toString());
            currentUser.setModified(new Date());
            int r = userServiceI.updateByPrimaryKey(currentUser);
            if(r<=0){
                logger.error("修改用户手机号失败");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"修改用户手机号失败!", null);
            }
        } catch (Exception e) {
            logger.error("用户手机号解密失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"用户手机号解密失败!", null);
        }
        System.out.println(currentUser);
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), currentUser);
    }


}
