package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.UserInfoMapper;
import com.ichaoge.pet.domain.entity.UserInfo;
import com.ichaoge.pet.domain.entity.UserInfoExample;
import com.ichaoge.pet.service.iservice.UserInfoServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/8/28.
 */
@Service
public class UserInfoServiceImpl implements UserInfoServiceI {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectByExample(UserInfo param){
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(param.getId().toString())) {
            criteria.andIdEqualTo(param.getId());
        }
        return userInfoMapper.selectByExample(userInfoExample);
    }

    @Override
    public int insert(UserInfo record){
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record){
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record){
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record){
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByUserId(UserInfo record){
        return userInfoMapper.updateByUserId(record);
    }

}
