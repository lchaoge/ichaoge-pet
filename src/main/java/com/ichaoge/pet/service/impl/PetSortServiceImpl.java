package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.PetSortMapper;
import com.ichaoge.pet.domain.entity.PetSort;
import com.ichaoge.pet.domain.entity.PetSortExample;
import com.ichaoge.pet.service.iservice.PetSortServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaoge on 2018/8/30.
 */
@Service
@Transactional
public class PetSortServiceImpl extends RuntimeException implements PetSortServiceI {

    @Resource
    private PetSortMapper petSortMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return petSortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PetSort record) {
        return petSortMapper.insert(record);
    }

    @Override
    public int insertSelective(PetSort record) {
        return petSortMapper.insertSelective(record);
    }

    @Override
    public List<PetSort> selectByExample(PetSortExample example) {
        return petSortMapper.selectByExample(example);
    }

    @Override
    public PetSort selectByPrimaryKey(Long id) {
        return petSortMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PetSort record) {
        return petSortMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PetSort record) {
        return petSortMapper.updateByPrimaryKey(record);
    }
}
