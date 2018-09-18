package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.Cart;
import com.ichaoge.pet.domain.entity.CartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface CartServiceI {
    int countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}
