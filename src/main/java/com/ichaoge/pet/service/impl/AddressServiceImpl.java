package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.AddressMapper;
import com.ichaoge.pet.domain.entity.Address;
import com.ichaoge.pet.domain.entity.AddressExample;
import com.ichaoge.pet.service.iservice.AddressServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
@Transactional
public class AddressServiceImpl extends RuntimeException implements AddressServiceI {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public int countByExample(AddressExample example) {
        return addressMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AddressExample example) {
        return addressMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    @Override
    public int insertSelective(Address record) {
        return addressMapper.insertSelective(record);
    }

    @Override
    public List<Address> selectByExample(Address address) {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(address.getUserId().toString())) {
            criteria.andUserIdEqualTo(address.getUserId());
        }
        return addressMapper.selectByExample(addressExample);
    }

    @Override
    public Address selectByPrimaryKey(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }
}
