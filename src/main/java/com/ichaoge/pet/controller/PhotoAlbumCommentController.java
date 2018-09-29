package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PhotoAlbumComment;
import com.ichaoge.pet.domain.inputParam.PetParam;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumCommentParam;
import com.ichaoge.pet.domain.output.CommentFloor;
import com.ichaoge.pet.service.iservice.PhotoAlbumCommentServiceI;
import com.ichaoge.pet.utils.IpUtils;
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

/**
 * Created by chaoge on 2018/9/28.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/photoAlbumComment")
public class PhotoAlbumCommentController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private PhotoAlbumCommentServiceI photoAlbumCommentServiceI;

    /**
     * 写真集评论新增
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> insert(HttpServletRequest request, @RequestBody PhotoAlbumComment param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        List<PhotoAlbumComment> result = null;

        //开始查询
        try {
            param.setCreated(new Date());
            param.setModified(new Date());
            param.setStatus(1);
            String ip = IpUtils.getIP(request);
            param.setIp(ip);
            Long floor = photoAlbumCommentServiceI.selectFloorByPhotoAlbumId(param.getPhotoAlbumId());
            param.setFloor(floor+1);
            int insertOK = photoAlbumCommentServiceI.insert(param);
            if(insertOK<=0){
                logger.error("写真集评论新增失败!");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"写真集评论新增失败!", null);
            }

            // 查询写真集的评论
            PhotoAlbumCommentParam photoAlbumCommentParam = new PhotoAlbumCommentParam();
            photoAlbumCommentParam.setPhotoAlbumId(param.getPhotoAlbumId());
            result = photoAlbumCommentServiceI.selectByExample(photoAlbumCommentParam);

            logger.info("应答参数：" + result + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), result);
    }

    /**
     * 根据写真集ID查询写真集所有楼层
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/selectAllFloor", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> selectAllFloor(HttpServletRequest request, @RequestBody PhotoAlbumComment param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        List<CommentFloor> result = null;

        //开始查询
        try {
            result = photoAlbumCommentServiceI.selectAllFloor(param.getPhotoAlbumId());
            if(result == null){
                logger.error("写真集评论查询失败!");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"写真集评论查询失败!", null);
            }

            logger.info("应答参数：" + result + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), result);
    }

}
