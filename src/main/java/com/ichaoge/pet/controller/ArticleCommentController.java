package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.service.iservice.ArticleCommentServiceI;
import com.ichaoge.pet.service.iservice.ArticleServiceI;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * Created by chaoge on 2018/9/18.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/articleComment")
public class ArticleCommentController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ArticleCommentController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private ArticleCommentServiceI articleCommentServiceI;

}