package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PhotoAlbum;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumParam;
import com.ichaoge.pet.service.iservice.PhotoAlbumServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by chaoge on 2018/9/20.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/photoAlbum")
public class PhotoAlbumController extends BaseController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PhotoAlbumController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private PhotoAlbumServiceI photoAlbumServiceI;

    /**
     * @param request
     * @param file
     * @return 上传成功返回“success”，上传失败返回“error”
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/uploadFile")
    public RemoteResult<?> uploadFile(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file){
        String path ="";
        try {
            InetAddress ia = InetAddress.getLocalHost();
            System.out.println(ia.getHostName());//域名               127
            System.out.println(ia.getHostAddress());//ip地址           192.168.201.254
            System.out.println(ia.getCanonicalHostName());

            request.setCharacterEncoding("UTF-8");
            logger.info("执行图片上传");

            if(!file.isEmpty()) {
                logger.info("成功获取照片");
                String fileName = file.getOriginalFilename();
                String imgType = null;
                imgType = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                logger.info("图片初始名称为：" + fileName + " 类型为：" + imgType);
                if (imgType != null) {
                    if ("GIF".equals(imgType.toUpperCase())||"PNG".equals(imgType.toUpperCase())||"JPG".equals(imgType.toUpperCase())) {
                        // 项目在容器中实际发布运行的根路径
                        String realPath = request.getSession().getServletContext().getRealPath("/");
                        // 自定义的文件名称
                        String trueFileName = "img-"+String.valueOf(System.currentTimeMillis()) + "."+imgType;
                        // 设置存放图片文件的路径
                        String imgPath = realPath + "/static/uploads/images/" + trueFileName;
                        logger.info("存放图片文件的路径:" + imgPath);
                        file.transferTo(new File(imgPath));
                        logger.info("文件成功上传到指定目录下");

                        // 修改图片地址
                        path = "http://" + ia.getHostAddress() + "/static/uploads/images/" + trueFileName;

                    }else {
                        logger.info("不是我们想要的文件类型,请按要求重新上传");
                        return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"不是我们想要的文件类型,请按要求重新上传!", null);
                    }
                }else {
                    logger.info("文件类型为空");
                    return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"文件类型为空!", null);
                }
            }else {
                logger.info("没有找到相对应的文件");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"没有找到相对应的文件!", null);
            }

        } catch (Exception e) {
            logger.error("服务区系统错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"服务区系统错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), path);
    }

    /**
     * 新增写真集
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> insert(HttpServletRequest request, @RequestBody PhotoAlbumParam param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        int result = -1;
        PhotoAlbum photoAlbum = null;
        param.setCreated(new Date());
        param.setModified(new Date());
        //开始查询
        try {
//            photoAlbumServiceI.insert(param);

            logger.info("应答参数：" + photoAlbum + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), photoAlbum);
    }

}
