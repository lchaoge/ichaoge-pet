package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.Collection;
import com.ichaoge.pet.domain.entity.CollectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
public interface CollectionServiceI {
    int countByExample(CollectionExample example);

    int deleteByExample(CollectionExample example);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

}
