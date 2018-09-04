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
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(param.getOpenid())) {
            criteria.andOpenidEqualTo(param.getOpenid());
        }
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(param.getUserName())) {
            criteria.andOpenidEqualTo(param.getUserName());
        }
        return userMapper.selectByExample(userExample);
    }

    @Override
    public int insert(User record){
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record){
        return userMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record){
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id){
        return userMapper.selectByPrimaryKey(id);
    }



}
