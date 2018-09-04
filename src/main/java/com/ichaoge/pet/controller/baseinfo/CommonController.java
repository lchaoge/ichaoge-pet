package com.ichaoge.pet.controller.baseinfo;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author chaoge
 * @date 2018-08-28
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/ichaoge/pet")
public class CommonController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CommonController.class);


}
