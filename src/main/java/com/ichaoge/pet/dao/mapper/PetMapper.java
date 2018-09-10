package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.Pet;
import com.ichaoge.pet.domain.entity.PetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetMapper {
    int countByExample(PetExample example);

    int deleteByExample(PetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Pet record);

    int insertSelective(Pet record);

    List<Pet> selectByExample(PetExample example);

    Pet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Pet record, @Param("example") PetExample example);

    int updateByExample(@Param("record") Pet record, @Param("example") PetExample example);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);

    Pet selectByCardNo(Long cardNo);
}