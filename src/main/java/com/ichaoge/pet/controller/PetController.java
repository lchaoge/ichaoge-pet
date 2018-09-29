package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PetExample;
import com.ichaoge.pet.domain.inputParam.PetParam;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumParam;
import com.ichaoge.pet.service.iservice.PetServiceI;
import com.ichaoge.pet.service.iservice.PhotoAlbumServiceI;
import com.ichaoge.pet.utils.IpUtils;
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
import java.util.*;

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
    @Resource
    private PhotoAlbumServiceI photoAlbumServiceI;


    /**
     * 新增
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> insert(HttpServletRequest request, @RequestBody Pet param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        int result = -1;
        Pet currentPet = null;
        param.setCreated(new Date());
        param.setModified(new Date());

        //开始查询
        try {
            PetParam userPet = new PetParam();
            userPet.setUserId(param.getUserId());
            List<Pet> pets = petServiceI.selectByExample(userPet);
            for (Pet p:pets) {
                if(p.getIsCurrent().equals(1)){
                    p.setIsCurrent(0);
                    petServiceI.updateByPrimaryKeySelective(p);
                }
            }

            long cardNo = 0;
            boolean isSuccess = true;
            int multiple = 1000000;
            while (isSuccess){
                cardNo = (long)(Math.random()*multiple);
                Pet pet = petServiceI.selectByCardNo(cardNo);
                if(pet==null){
                    param.setCardNo(cardNo);
                    param.setIsCurrent(1);
                    result = petServiceI.insertSelective(param);
                    if(result<0){
                        logger.error("查询发生未知错误!");
                        return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
                    }else{
                        isSuccess = false;
                        currentPet = petServiceI.selectByCardNo(cardNo);
                    }
                }
            }

            logger.info("应答参数：" + currentPet + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), currentPet);
    }

    /**
     * 修改萌宠卡
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> update(HttpServletRequest request, @RequestBody Pet param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        Pet currentPet = null;
        param.setModified(new Date());
        //开始查询
        try {
            // 修改用户萌宠卡的默认卡
            PetParam userPet = new PetParam();
            userPet.setUserId(param.getUserId());
            List<Pet> pets = petServiceI.selectByExample(userPet);
            for (Pet p:pets) {
                if(p.getIsCurrent().equals(1)){
                    p.setIsCurrent(0);
                    petServiceI.updateByPrimaryKeySelective(p);
                }
            }
            // 修改为当前卡
            int result = petServiceI.updateByPrimaryKeySelective(param);
            if(result<0){
                logger.error("修改宠物卡失败!");
                return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"修改宠物卡失败!", null);
            }else{
                currentPet = petServiceI.selectByCardNo(param.getCardNo());
            }

            logger.info("应答参数：" + currentPet + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), currentPet);
    }

    /**
     * @param request
     * @param file
     * @return 上传成功返回“success”，上传失败返回“error”
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/uploadFile")
    public RemoteResult<?> uploadFile(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file){
        System.out.println("uploadFile");
        Pet pet = new Pet();  // 图片路径
        String IP = "";
        try {
            InetAddress ia = InetAddress.getLocalHost();
            System.out.println(ia.getHostName());//域名               127
            System.out.println(ia.getHostAddress());//ip地址           192.168.201.254
            System.out.println(ia.getCanonicalHostName());

            request.setCharacterEncoding("UTF-8");
            logger.info("执行图片上传");
//            String user = request.getParameter("user");
//            logger.info("user:"+user);
            if(!file.isEmpty()) {
                logger.info("成功获取照片");
                String fileName = file.getOriginalFilename();
                String type = null;
                type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                logger.info("图片初始名称为：" + fileName + " 类型为：" + type);
                if (type != null) {
                    if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                        // 项目在容器中实际发布运行的根路径
                        String realPath = request.getSession().getServletContext().getRealPath("/");
                        // 自定义的文件名称
//                        String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                        String trueFileName = "img-"+String.valueOf(System.currentTimeMillis()) + "."+type;
                        // 设置存放图片文件的路径
                        pet.setPhoto(realPath + "/static/uploads/images/" + trueFileName);
                        logger.info("存放图片文件的路径:" + pet.getPhoto());
                        file.transferTo(new File(pet.getPhoto()));
                        logger.info("文件成功上传到指定目录下");

                        // 修改图片地址
                        String path = "http://pet.ichaoge.com:3000/static/uploads/images/" + trueFileName;
                        pet.setPhoto(path);
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
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), pet);
    }


    /**
     * 查询所有萌宠卡
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryPetAll", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryPetAll(HttpServletRequest request, @RequestBody PetParam param) {
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

    /**
     * @查询写真集数量
     * @查询传记数量
     * @查询健康数量
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryCount", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryCount(HttpServletRequest request, @RequestBody Pet param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        Map<String,Object> result = new HashMap<String,Object>();
        //开始查询
        try {
            PhotoAlbumParam photoAlbumParam = new PhotoAlbumParam();
            photoAlbumParam.setPetId(param.getId());
            int photoAlnumCount = photoAlbumServiceI.countByExample(photoAlbumParam);
            // 写真集
            result.put("photoAlnumCount",photoAlnumCount);

            // TODO: 2018/9/25 查询传记数量

            // TODO: 2018/9/25 查询健康数量

            logger.info("应答参数：" + result + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), result);
    }

}
