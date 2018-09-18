package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.OrderMain;
import com.ichaoge.pet.domain.entity.OrderMainExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface OrderMainServiceI {
    int countByExample(OrderMainExample example);

    int deleteByExample(OrderMainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderMain record);

    int insertSelective(OrderMain record);

    List<OrderMain> selectByExample(OrderMainExample example);

    OrderMain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderMain record);

    int updateByPrimaryKey(OrderMain record);
}
