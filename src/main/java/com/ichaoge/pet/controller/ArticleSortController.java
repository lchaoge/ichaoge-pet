package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.ArticleImage;
import com.ichaoge.pet.domain.entity.ArticleImageExample;
import com.ichaoge.pet.domain.entity.ArticleSort;
import com.ichaoge.pet.domain.entity.ArticleSortExample;
import com.ichaoge.pet.service.iservice.ArticleImageServiceI;
import com.ichaoge.pet.service.iservice.ArticleSortServiceI;
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
@RequestMapping("/api/articleSort")
public class ArticleSortController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ArticleSortController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private ArticleSortServiceI articleSortServiceI;

    /**
     * 查询列表
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryAll(HttpServletRequest request, @RequestBody ArticleSort param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        List<ArticleSort> articleSortList = null;
        //开始查询
        try {
            articleSortList = articleSortServiceI.selectByExample(new ArticleSortExample());

            logger.info("应答参数：" + articleSortList + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询列表失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询列表失败!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), articleSortList);
    }

}
