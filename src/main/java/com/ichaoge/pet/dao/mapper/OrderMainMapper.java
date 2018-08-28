package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.OrderMain;
import com.ichaoge.pet.domain.entity.OrderMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMainMapper {
    int countByExample(OrderMainExample example);

    int deleteByExample(OrderMainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderMain record);

    int insertSelective(OrderMain record);

    List<OrderMain> selectByExample(OrderMainExample example);

    OrderMain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderMain record, @Param("example") OrderMainExample example);

    int updateByExample(@Param("record") OrderMain record, @Param("example") OrderMainExample example);

    int updateByPrimaryKeySelective(OrderMain record);

    int updateByPrimaryKey(OrderMain record);
}