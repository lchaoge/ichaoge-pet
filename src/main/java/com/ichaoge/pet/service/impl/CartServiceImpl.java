package com.ichaoge.pet.service.impl;

import org.springframework.stereotype.Service;
import com.ichaoge.pet.dao.mapper.CartMapper;
import com.ichaoge.pet.domain.entity.Cart;
import com.ichaoge.pet.domain.entity.CartExample;
import com.ichaoge.pet.service.iservice.CartServiceI;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
@Transactional
public class CartServiceImpl extends RuntimeException implements CartServiceI {

    @Resource
    private CartMapper cartMapper;

    @Override
    public int countByExample(CartExample example) {
        return cartMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CartExample example) {
        return cartMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return cartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Cart record) {
        return cartMapper.insert(record);
    }

    @Override
    public int insertSelective(Cart record) {
        return cartMapper.insertSelective(record);
    }

    @Override
    public List<Cart> selectByExample(CartExample example) {
        return cartMapper.selectByExample(example);
    }

    @Override
    public Cart selectByPrimaryKey(Long id) {
        return cartMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cart record) {
        return cartMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Cart record) {
        return cartMapper.updateByPrimaryKey(record);
    }
}
