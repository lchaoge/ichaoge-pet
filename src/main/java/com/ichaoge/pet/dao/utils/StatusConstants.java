package com.ichaoge.pet.dao.utils;

/**
 * Created by nikoou on 2016/4/29.
 */
public class StatusConstants {
    /**创建记录*/
    public static final String CREATE_OBJ = "001";
    /**修改记录*/
    public static final String MODIFY_OBJ = "002";
    /**删除记录*/
    public static final String DELETE_OBJ = "003";

    //===车位占用状态===START===========================
    public static final Integer CAR_OCCUPY = 1;//占用
    public static final Integer CAR_REMOVE = 0;//空闲
    public static final Integer CAR_LEAVE  = 2;//离开，删除
    //===车位占用状态===END  ===========================



}
