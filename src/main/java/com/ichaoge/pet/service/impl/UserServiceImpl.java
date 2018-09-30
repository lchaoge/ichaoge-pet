package com.ichaoge.pet.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ichaoge.pet.common.constant.CommConst;
import com.ichaoge.pet.controller.UserController;
import com.ichaoge.pet.dao.mapper.UserMapper;
import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.entity.UserExample;
import com.ichaoge.pet.domain.inputParam.UserParam;
import com.ichaoge.pet.service.iservice.UserServiceI;
import com.ichaoge.pet.utils.HttpClientUtil;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;

/**
 * Created by chaoge on 2018/8/28.
 */
@Service
@Transactional
public class UserServiceImpl extends RuntimeException implements UserServiceI {

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
            criteria.andUserNameEqualTo(param.getUserName());
        }
        if (org.apache.commons.lang.StringUtils.isNotEmpty(param.getPhone())) {
            criteria.andPhoneEqualTo(param.getPhone());
        }
        if (org.apache.commons.lang.StringUtils.isNotEmpty(param.getEmail())) {
            criteria.andEmailEqualTo(param.getEmail());
        }
        userExample.setOrderByClause("id desc");
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

    // 解密手机号码
    public String decrypt(byte[] key, byte[] iv, byte[] encData){
        String str = "";
        try {
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            str = new String(cipher.doFinal(encData),"UTF-8");
        }catch (Exception e){
            System.out.println("用户手机号解密失败"+e);
        }
        return str;
    }
    public Pagination queryAllPage(UserParam param){
        Integer pageSize = param.getPageSize() != null ? param.getPageSize() : CommConst.PAGE_SIZE;
        Integer currentPage = param.getCurrentPage() != null ? param.getCurrentPage() : CommConst.CURRENT_PAGE;
        Pagination pagination = new Pagination(currentPage, pageSize);
        //开始查询
        PageHelper.startPage(currentPage, pageSize);
        List<User> users = selectByExample(param);

        PageInfo<User> pageInfo = new PageInfo(users);
        pagination.setCount((int) pageInfo.getTotal());
        pagination.setData(users);
        return pagination;
    }

}
