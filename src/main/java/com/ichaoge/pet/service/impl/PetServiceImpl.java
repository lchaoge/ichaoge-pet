package com.ichaoge.pet.service.impl;

import com.ichaoge.pet.dao.mapper.PetMapper;
import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PetExample;
import com.ichaoge.pet.domain.entity.UserExample;
import com.ichaoge.pet.domain.inputParam.PetParam;
import com.ichaoge.pet.service.iservice.PetServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chaoge on 2018/8/30.
 */
@Service
@Transactional
public class PetServiceImpl extends RuntimeException implements PetServiceI {

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
    public List<Pet> selectByExample(PetParam param) {
        PetExample petExample = new PetExample();
        PetExample.Criteria criteria = petExample.createCriteria();
        if(param.getId()!=null){
            criteria.andIdEqualTo(param.getId());
        }
        if(param.getUserId()!=null){
            criteria.andUserIdEqualTo(param.getUserId());
        }
        if(param.getCardNo()!=null){
            criteria.andCardNoEqualTo(param.getCardNo());
        }
        if(param.getIsCurrent()!=null){
            criteria.andIsCurrentEqualTo(param.getIsCurrent());
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
