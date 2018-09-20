package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.entity.User;
import com.ichaoge.pet.domain.entity.UserExample;
import java.util.List;

import com.ichaoge.pet.domain.inputParam.UserParam;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}