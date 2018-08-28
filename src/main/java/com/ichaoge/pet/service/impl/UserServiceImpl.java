package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.UserMapper;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.entity.UserExample;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.service.iservice.UserServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/8/28.
 */
@Service
public class UserServiceImpl implements UserServiceI {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectByExample(UserParam param){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        return userMapper.selectByExample(userExample);
    }
}
