package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Cart;
import com.ichaoge.pet.domain.entity.CartExample;
import com.ichaoge.pet.domain.entity.Collection;
import com.ichaoge.pet.domain.entity.CollectionExample;
import com.ichaoge.pet.service.iservice.CartServiceI;
import com.ichaoge.pet.service.iservice.CollectionServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/collection")
public class CollectionController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CollectionController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private CollectionServiceI collectionServiceI;

    /**
     * 查询列表
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryAll(HttpServletRequest request, @RequestBody Collection param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        List<Collection> collectionList = null;
        //开始查询
        try {
            collectionList = collectionServiceI.selectByExample(new CollectionExample());

            logger.info("应答参数：" + collectionList + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询列表失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询列表失败!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), collectionList);
    }

}
