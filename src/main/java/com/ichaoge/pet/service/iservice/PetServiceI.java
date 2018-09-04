package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PetExample;

import java.util.List;

/**
 * Created by chaoge on 2018/8/30.
 */
public interface PetServiceI {

    int insert(Pet record);

    int insertSelective(Pet record);

    List<Pet> selectByExample(Pet pet);

    Pet selectByPrimaryKey(Long id);

    Pet selectByCardNo(Long cardNo);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);

}
