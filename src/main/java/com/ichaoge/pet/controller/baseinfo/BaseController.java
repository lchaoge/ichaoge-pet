/**
 * Project Name:position-appointment-web
 * File Name:BaseController.java
 * Package Name:com.ichaoge.pet.controller.baseinfo
 * Date:2016年9月21日下午9:05:20
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.
 */
package com.ichaoge.pet.controller.baseinfo;

import com.retail.cx.web.interceptor.LoginContext;

/**
 * ClassName: BaseController
 * date: 2018年4月21日 下午9:05:20
 *
 * @author chaoge
 */
public class BaseController {
    public String getUser() {
        String userNo = "-1";
        LoginContext lc = LoginContext.getLoginContext();
        if (lc != null) {
            userNo = lc.getAccount();
        }
        return userNo;
    }
}
