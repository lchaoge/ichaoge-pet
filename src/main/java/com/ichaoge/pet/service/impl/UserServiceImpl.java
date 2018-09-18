package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.controller.UserController;
import com.ichaoge.pet.dao.mapper.UserMapper;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.entity.UserExample;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.service.iservice.UserServiceI;
import com.ichaoge.pet.utils.HttpClientUtil;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/8/28.
 */
@Service
public class UserServiceImpl implements UserServiceI {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
    // 获取openid
    @Override
    public String selectByCode(String code){
        String appid = "wx216e84db512d7ab5";
        String secret = "7d983f1bdbdf345deed336515c392843";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
        logger.info("请求地址：" + url + "  " + "请求参数：" + code);
        String resultJson = HttpClientUtil.doGet(url);
        return resultJson;
    }



}
