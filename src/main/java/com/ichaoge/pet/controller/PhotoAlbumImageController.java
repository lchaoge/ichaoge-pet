package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.service.iservice.PhotoAlbumImageServiceI;
import com.ichaoge.pet.service.iservice.PhotoAlbumServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by chaoge on 2018/9/20.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/photoAlbumImage")
public class PhotoAlbumImageController extends BaseController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PhotoAlbumImageController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private PhotoAlbumImageServiceI photoAlbumImageServiceI;

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
//            pagination = userServiceI.queryAllPage(param);
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

}
