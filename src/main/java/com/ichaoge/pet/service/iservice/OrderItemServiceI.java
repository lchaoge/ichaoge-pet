package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.OrderItem;
import com.ichaoge.pet.domain.entity.OrderItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface OrderItemServiceI {
    int countByExample(OrderItemExample example);

    int deleteByExample(OrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}
