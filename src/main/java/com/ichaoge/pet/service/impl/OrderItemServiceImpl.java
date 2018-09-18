package com.ichaoge.pet.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ichaoge.pet.dao.mapper.OrderItemMapper;
import com.ichaoge.pet.domain.entity.OrderItem;
import com.ichaoge.pet.domain.entity.OrderItemExample;
import com.ichaoge.pet.service.iservice.OrderItemServiceI;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
public class OrderItemServiceImpl implements OrderItemServiceI {
    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public int countByExample(OrderItemExample example) {
        return orderItemMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderItemExample example) {
        return orderItemMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderItem record) {
        return orderItemMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderItem record) {
        return orderItemMapper.insertSelective(record);
    }

    @Override
    public List<OrderItem> selectByExample(OrderItemExample example) {
        return orderItemMapper.selectByExample(example);
    }

    @Override
    public OrderItem selectByPrimaryKey(Long id) {
        return orderItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItem record) {
        return orderItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderItem record) {
        return orderItemMapper.updateByPrimaryKey(record);
    }
}
