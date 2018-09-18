package com.ichaoge.pet.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ichaoge.pet.dao.mapper.CollectionMapper;
import com.ichaoge.pet.domain.entity.Collection;
import com.ichaoge.pet.domain.entity.CollectionExample;
import com.ichaoge.pet.service.iservice.CollectionServiceI;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@Service
public class CollectionServiceImpl implements CollectionServiceI {
    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public int countByExample(CollectionExample example) {
        return collectionMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CollectionExample example) {
        return collectionMapper.deleteByExample(example);
    }

    @Override
    public int insert(Collection record) {
        return collectionMapper.insert(record);
    }

    @Override
    public int insertSelective(Collection record) {
        return collectionMapper.insertSelective(record);
    }

    @Override
    public List<Collection> selectByExample(CollectionExample example) {
        return collectionMapper.selectByExample(example);
    }
}
