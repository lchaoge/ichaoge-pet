package com.ichaoge.pet.service.impl;

import org.springframework.stereotype.Service;
import com.ichaoge.pet.dao.mapper.OrderMainMapper;
import com.ichaoge.pet.domain.entity.OrderMain;
import com.ichaoge.pet.domain.entity.OrderMainExample;
import com.ichaoge.pet.service.iservice.OrderMainServiceI;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
public class OrderMainServiceImpl implements OrderMainServiceI {

    @Resource
    private OrderMainMapper orderMainMapper;

    @Override
    public int countByExample(OrderMainExample example) {
        return orderMainMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderMainExample example) {
        return orderMainMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderMainMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderMain record) {
        return orderMainMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderMain record) {
        return orderMainMapper.insertSelective(record);
    }

    @Override
    public List<OrderMain> selectByExample(OrderMainExample example) {
        return orderMainMapper.selectByExample(example);
    }

    @Override
    public OrderMain selectByPrimaryKey(Long id) {
        return orderMainMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderMain record) {
        return orderMainMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderMain record) {
        return orderMainMapper.updateByPrimaryKey(record);
    }
}
