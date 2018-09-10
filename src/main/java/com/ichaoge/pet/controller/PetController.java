package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PetExample;
import com.ichaoge.pet.service.iservice.PetServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by chaoge on 2018/8/30.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/pet")
public class PetController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PetController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private PetServiceI petServiceI;

    /**
     * 插入宠物卡
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> insert(HttpServletRequest request, @RequestBody Pet param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        int result = -1;
        param.setCreated(new Date());
        param.setModified(new Date());
        //开始查询
        try {
            long cardNo = 0;
            boolean isSuccess = true;
            int multiple = 1000000;
            while (isSuccess){
                cardNo = (long)(Math.random()*multiple);
                Pet p = petServiceI.selectByCardNo(cardNo);
                if(p==null){
                    param.setCardNo(cardNo);
                    result = petServiceI.insertSelective(param);
                    if(result<0){
                        logger.error("查询发生未知错误!");
                        return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
                    }else{
                        isSuccess = false;
                    }
                }
            }

            logger.info("应答参数：" + result + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), result);
    }

    /**
     * 查询所有萌宠卡
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryPetAll", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryPetAll(HttpServletRequest request, @RequestBody Pet param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        List<Pet> pets = null;
        //开始查询
        try {
            pets = petServiceI.selectByExample(param);
            logger.info("应答参数：" + pets + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), pets);
    }


    /**
     * 根据id查询宠物
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryPetById", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryPetById(HttpServletRequest request, @RequestBody Pet param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        Pet pet = null;
        //开始查询
            try {
            pet = petServiceI.selectByPrimaryKey(param.getId());
            logger.info("应答参数：" + pet + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), pet);
    }

}
