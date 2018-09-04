package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.UserInfo;

import java.util.List;

/**
 * Created by chaoge on 2018/8/28.
 */
public interface UserInfoServiceI {
    List<UserInfo> selectByExample(UserInfo param);
    int insert(UserInfo record);
    int insertSelective(UserInfo record);
    int updateByPrimaryKeySelective(UserInfo record);
    int updateByPrimaryKey(UserInfo record);
    int updateByUserId(UserInfo record);
}
