package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.PetMapper;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PetExample;
import com.ichaoge.pet.domain.entity.UserExample;
import com.ichaoge.pet.service.iservice.PetServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chaoge on 2018/8/30.
 */
@Service
public class PetServiceImpl implements PetServiceI {

    @Resource
    private PetMapper petMapper;

    @Override
    public int insert(Pet record) {
        return petMapper.insert(record);
    }

    @Override
    public int insertSelective(Pet record) {
        return petMapper.insertSelective(record);
    }

    @Override
    public List<Pet> selectByExample(Pet pet) {
        PetExample petExample = new PetExample();
        PetExample.Criteria criteria = petExample.createCriteria();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(pet.getUserId().toString())) {
            criteria.andUserIdEqualTo(pet.getUserId());
        }
        return petMapper.selectByExample(petExample);
    }

    @Override
    public Pet selectByPrimaryKey(Long id) {
        return petMapper.selectByPrimaryKey(id);
    }

    @Override
    public Pet selectByCardNo(Long cardNo){
        return petMapper.selectByCardNo(cardNo);
    }

    @Override
    public int updateByPrimaryKeySelective(Pet record) {
        return petMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Pet record) {
        return petMapper.updateByPrimaryKey(record);
    }
}
