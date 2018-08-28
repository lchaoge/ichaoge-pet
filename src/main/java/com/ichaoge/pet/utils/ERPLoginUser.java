package com.ichaoge.pet.utils;

import com.retail.web.interceptor.LoginContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Fanhaibo on 2016/5/19.
 */
public class ERPLoginUser {

    private static final Logger logger = LoggerFactory.getLogger("station_reservation_log");

    public static LoginContext getCxLoginContext() {
        try {
            LoginContext loginContext = LoginContext.getLoginContext();
            return loginContext;
        } catch (Exception e) {
            logger.error("ERPLoginUser  获取cx登陆信息失败 :  " + e.getMessage(),e);
            return null;
        }
    }
}
