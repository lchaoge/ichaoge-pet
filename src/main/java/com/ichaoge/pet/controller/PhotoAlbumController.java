package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PhotoAlbum;
import com.ichaoge.pet.domain.entity.PhotoAlbumImage;
import com.ichaoge.pet.domain.entity.PhotoAlbumLabelSort;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumParam;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.service.iservice.LabelSortServiceI;
import com.ichaoge.pet.service.iservice.PhotoAlbumImageServiceI;
import com.ichaoge.pet.service.iservice.PhotoAlbumLabelSortServiceI;
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
    @Resource
    private PhotoAlbumImageServiceI photoAlbumImageServiceI;
    @Resource
    private PhotoAlbumLabelSortServiceI photoAlbumLabelSortServiceI;

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
            String type = request.getParameter("type");
            logger.info("文件类型type:"+type);
            if(!file.isEmpty()) {
                logger.info("成功获取照片");
                String fileName = file.getOriginalFilename();
                String imgType = null;
                imgType = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                logger.info("图片初始名称为：" + fileName + " 类型为：" + imgType);

                if (imgType != null) {
//                    if ("GIF".equals(imgType.toUpperCase())||"PNG".equals(imgType.toUpperCase())||"JPG".equals(imgType.toUpperCase())||"JPEG".equals(imgType.toUpperCase())) {
                    if(type.equals("1")){
                        // 图片
                        // 项目在容器中实际发布运行的根路径
                        String realPath = request.getSession().getServletContext().getRealPath("/");
                        // 自定义的文件名称
                        String trueFileName = "img-"+String.valueOf(System.currentTimeMillis()) + "."+imgType;
                        // 设置存放图片文件的路径
                        String imgPath = realPath + "/static/uploads/images/" + trueFileName;
                        logger.info("存放图片文件的路径:" + imgPath);
                        file.transferTo(new File(imgPath));
                        logger.info("图片成功上传到指定目录下");

                        // 修改图片地址
                        path = "http://" + ia.getHostAddress() + "/static/uploads/images/" + trueFileName;
                    }else{
                        // 视频
                        // 项目在容器中实际发布运行的根路径
                        String realPath = request.getSession().getServletContext().getRealPath("/");
                        // 自定义的文件名称
                        String trueFileName = "video-"+String.valueOf(System.currentTimeMillis()) + "."+imgType;
                        // 设置存放图片文件的路径
                        String imgPath = realPath + "/static/uploads/video/" + trueFileName;
                        logger.info("存放视频文件的路径:" + imgPath);
                        file.transferTo(new File(imgPath));
                        logger.info("视频成功上传到指定目录下");

                        // 修改图片地址
                        path = "http://" + ia.getHostAddress() + "/static/uploads/video/" + trueFileName;
                    }


//                    }else {
//                        logger.info("不是我们想要的文件类型,请按要求重新上传");
//                        return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"不是我们想要的文件类型,请按要求重新上传!", null);
//                    }
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

        //开始查询
        try {
            // 新增写真集
            PhotoAlbum photoAlbum = new PhotoAlbum();
            photoAlbum.setType(param.getType());
            photoAlbum.setRecommend(param.getRecommend());
            photoAlbum.setRecordDate(param.getRecordDate());
            photoAlbum.setPetId(param.getPetId());
            photoAlbum.setContent(param.getContent());
            photoAlbum.setStatus(1);
            photoAlbum.setCreated(new Date());
            photoAlbum.setModified(new Date());
            result = photoAlbumServiceI.insert(photoAlbum);
            if(result>0){
                // 新增图片
                String[] photoAlbumImageList = param.getPhotoAlbumImageList();
                for (int i = 0; i < photoAlbumImageList.length; i++) {
                    PhotoAlbumImage p = new PhotoAlbumImage();
                    p.setPetId(param.getPetId());
                    p.setPhotoAlbumId(photoAlbum.getId());
                    p.setImageUrl(photoAlbumImageList[i]);
                    p.setStatus(1);
                    p.setCreated(new Date());
                    p.setModified(new Date());
                    photoAlbumImageServiceI.insert(p);
                }
                // 增加标签
                String[] labelSortList = param.getLabelSortList();
                for (int i = 0; i < labelSortList.length; i++) {
                    PhotoAlbumLabelSort  p = new PhotoAlbumLabelSort();
                    p.setLabelSortId(Long.parseLong(labelSortList[i]));
                    p.setPhotoAlbumId(photoAlbum.getId());
                    p.setCreated(new Date());
                    p.setModified(new Date());
                    photoAlbumLabelSortServiceI.insert(p);
                }
            }else{
                logger.error("新增写真集失败!");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"新增写真集失败!", null);
            }

            logger.info("应答参数：" + photoAlbum + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("新增写真集失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"新增写真集失败!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), result);
    }


    /**
     * 分页查询
     *
     * @param param
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryAllPage", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryAllPage(HttpServletRequest request, @RequestBody PhotoAlbumParam param) {
        logger.info("请求地址：" + request.getRequestURI() + "  " + "请求参数：" + param.toString() + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        Pagination pagination = null;
        //开始查询
        try {
            pagination = photoAlbumServiceI.queryAllPage(param);
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
