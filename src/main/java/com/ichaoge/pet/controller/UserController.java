package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.entity.UserInfo;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.service.iservice.PetServiceI;
import com.ichaoge.pet.service.iservice.UserInfoServiceI;
import com.ichaoge.pet.service.iservice.UserServiceI;
import com.ichaoge.pet.utils.HttpClientUtil;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
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
     * 查询用户
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

    /**
     * 解密并且获取用户手机号码
     * @param encrypdata
     * @param ivdata
     * @param code
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deciphering", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> deciphering(HttpServletRequest request,String encrypdata,String ivdata, String code) {
        String str="";

        try {
            String resultJson = userServiceI.selectByCode(code);
            JSONObject jsonObject=JSONObject.fromObject(resultJson);
            String session_key = jsonObject.get("session_key").toString();

            byte[] encrypData = Base64.decode(encrypdata);
            byte[] ivData = Base64.decode(ivdata);
            byte[] sessionKey = Base64.decode(session_key);


            str = decrypt(sessionKey,ivData,encrypData);
        } catch (Exception e) {
            logger.error("用户手机号解密失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"用户手机号解密失败!", null);
        }
        System.out.println(str);
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), str);

    }
    public static String decrypt(byte[] key, byte[] iv, byte[] encData) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        //解析解密后的字符串
        return new String(cipher.doFinal(encData),"UTF-8");
    }


}
