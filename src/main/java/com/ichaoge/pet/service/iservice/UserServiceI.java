package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.entity.UserExample;
import com.ichaoge.pet.domain.inputParam.UserParam;

import java.util.List;

/**
 * Created by Administrator on 2018/8/9.
 */
public interface UserServiceI {
    List<User> selectByExample(UserParam param);
}
