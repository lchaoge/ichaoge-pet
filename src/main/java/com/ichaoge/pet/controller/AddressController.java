package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Address;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.service.iservice.AddressServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scala.util.parsing.json.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/address")
public class AddressController extends BaseController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PetController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private AddressServiceI addressServiceI;

    /**
     * 添加收货地址
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> insert(HttpServletRequest request, @RequestBody Address param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        int result = -1;
        Address address = null;

        //开始查询
        try {
            // 修改默认地址
            Address userAddress = new Address();
            userAddress.setUserId(param.getUserId());
            List<Address> addressList = addressServiceI.selectByExample(userAddress);
            for (Address a:addressList) {
                addressServiceI.deleteByPrimaryKey(a.getId());
            }

            // 增加默认地址
            param.setCreated(new Date());
            param.setModified(new Date());
            param.setIsDefault(1);
            result = addressServiceI.insertSelective(param);
            if(result<0){
                logger.error("增加默认地址失败!");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"增加默认地址失败!", null);
            }else{
                address = addressServiceI.selectByExample(param).get(0);
            }

            logger.info("应答参数：" + address + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("增加默认地址失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"增加默认地址失败!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), address);
    }

    /**
     * 查询用户的默认收货地址
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/isDefault", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> isDefault(HttpServletRequest request, @RequestBody Address param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        Address address = null;
        //开始查询
        try {
            // 修改默认地址
            param.setIsDefault(1);
            List<Address> addressList = addressServiceI.selectByExample(param);
            address = addressList.get(0);

            logger.info("应答参数：" + address + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询默认收货地址失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询默认收货地址失败!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), address);
    }

}
