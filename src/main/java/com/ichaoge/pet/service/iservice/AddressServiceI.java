package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.Address;
import com.ichaoge.pet.domain.entity.AddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface AddressServiceI {
    int countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(Address address);

    Address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}
