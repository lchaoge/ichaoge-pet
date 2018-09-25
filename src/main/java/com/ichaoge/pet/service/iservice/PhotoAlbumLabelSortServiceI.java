package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.PhotoAlbumLabelSort;
import com.ichaoge.pet.domain.entity.PhotoAlbumLabelSortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/25.
 */
public interface PhotoAlbumLabelSortServiceI {
    int countByExample(PhotoAlbumLabelSortExample example);

    int deleteByExample(PhotoAlbumLabelSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbumLabelSort record);

    int insertSelective(PhotoAlbumLabelSort record);

    List<PhotoAlbumLabelSort> selectByExample(PhotoAlbumLabelSortExample example);

    PhotoAlbumLabelSort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PhotoAlbumLabelSort record);

    int updateByPrimaryKey(PhotoAlbumLabelSort record);
}
