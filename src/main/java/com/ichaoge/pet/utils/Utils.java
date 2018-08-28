package com.ichaoge.pet.utils;


import com.retail.sap.api.base.RemoteResult;

/**
 * Created by LiuYu on 2016/4/26.
 */
public class Utils {

    /**
     * 返回给页面的结果对象的快捷获得实例的方法
     * @param <T>
     * @param isSuccess
     * @param code
     * @param message
     * @param model
     * @return
     */
    public static<T> RemoteResult<T> webResult(boolean isSuccess, String code, String message, T model) {
        RemoteResult<T> result = new RemoteResult<T>();
        result.setCode(code);
        result.setSuccess(isSuccess);
        result.setMessage(message);
        result.setModel(model);

        return result;
    }

    /**
     * 返回给页面的结果对象的快捷获得实例的方法
     * @param <T>
     * @param isSuccess
     * @param code
     * @param message
     * @param model
     * @return
     */
    public static<T> RemoteResult<T> webResult(boolean isSuccess, int code, String message, T model) {
        RemoteResult<T> result = new RemoteResult<T>();
        result.setCode(code+"");
        result.setSuccess(isSuccess);
        result.setMessage(message);
        result.setModel(model);

        return result;
    }

    /**
     * 判断一个对象列表是否为空，如果对象是String还要判断其是否为空字串
     * 短路判断，只有有一个对象为空则马上返回。
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object... obj) {
        if(obj!=null) {
            for(int i=0;i<obj.length;i++) {
                if(isEmpty(obj[i]))
                    return true;
            }
        } else {
            return true;
        }
        return false;
    }

    /**
     * 判断一个对象是否为空，如果对象是String还要判断其是否为空字串
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if(obj==null)
            return true;

        if(obj instanceof String) {
            if(((String) obj).trim().equals("")) {
                return true;
            }
        }

        return false;
    }


    public static String transSupplier2Ten(String supplier) {
        if (supplier != null && supplier.length() != 0){
            int length = supplier.length();
            for (int i = 0; i < 10 - length; i++) {
                supplier = "0"+supplier;
            }
        }
        return supplier;
    }




}
