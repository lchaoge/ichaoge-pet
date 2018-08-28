package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.Collection;
import com.ichaoge.pet.domain.entity.CollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionMapper {
    int countByExample(CollectionExample example);

    int deleteByExample(CollectionExample example);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    int updateByExampleSelective(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByExample(@Param("record") Collection record, @Param("example") CollectionExample example);
}