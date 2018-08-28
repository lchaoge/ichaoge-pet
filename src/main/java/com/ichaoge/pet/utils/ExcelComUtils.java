package com.ichaoge.pet.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * 设置excel 编码
 * Created by shaoyn 2018-6-25
 */
public class ExcelComUtils {

    public static void compParam(String fileName, HttpServletResponse response, HttpServletRequest request)
            throws Exception {
        String userAgent = request.getHeader("User-Agent");
        fileName = URLEncoder.encode(fileName, "UTF8");
        // 默认使用IE的方式进行编码
        String rtn = "filename=\"" + fileName + "\"";
        rtn = compRtn(fileName, userAgent, rtn);
        // 设置response的头信息
        response.setHeader("Content-disposition", "attachment;" + rtn);
    }
    private static String compRtn(String fileName, String userAgent, String rtn) throws Exception {
        if (userAgent != null) {
            userAgent = userAgent.toLowerCase();
            // IE浏览器，只能采用URLEncoder编码
            if (userAgent.indexOf("msie") != -1) {
                rtn = "filename=\"" + fileName + "\"";
            }
            // Opera浏览器只能采用filename*
            else if (userAgent.indexOf("opera") != -1) {
                rtn = "filename*=UTF-8''" + fileName;
            }
            // Safari浏览器，只能采用ISO编码的中文输出
            else if (userAgent.indexOf("safari") != -1) {
                rtn = "filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\"";
            }
            // Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出
            // else if (userAgent.indexOf("applewebkit") != -1) {
            // fileName = MimeUtility.encodeText(fileName, "UTF8", "B");
            // rtn = "filename=\"" + fileName + "\"";
            // }
            // FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
            else if (userAgent.indexOf("mozilla") != -1) {
                rtn = "filename*=UTF-8''" + fileName;
            }
        }
        return rtn;
    }
}
