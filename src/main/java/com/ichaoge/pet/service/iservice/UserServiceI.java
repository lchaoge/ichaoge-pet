package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.inputParam.UserParam;

import java.util.List;

/**
 * Created by chaoge on 2018/8/28.
 */
public interface UserServiceI {
    List<User> selectByExample(UserParam param);
    int insert(User record);
    int insertSelective(User record);
    int updateByPrimaryKey(User record);
    int updateByPrimaryKeySelective(User record);
    User selectByPrimaryKey(Long id);
    // 获取openid
    String selectByCode(String code);
    // 解密手机号码
    String decrypt(byte[] key, byte[] iv, byte[] encData);
    // 分页查询
    Pagination queryAllPage(UserParam param);
}
