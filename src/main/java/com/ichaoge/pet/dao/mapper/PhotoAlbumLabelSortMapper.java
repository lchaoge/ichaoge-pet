package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.PhotoAlbumLabelSort;
import com.ichaoge.pet.domain.entity.PhotoAlbumLabelSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoAlbumLabelSortMapper {
    int countByExample(PhotoAlbumLabelSortExample example);

    int deleteByExample(PhotoAlbumLabelSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbumLabelSort record);

    int insertSelective(PhotoAlbumLabelSort record);

    List<PhotoAlbumLabelSort> selectByExample(PhotoAlbumLabelSortExample example);

    PhotoAlbumLabelSort selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhotoAlbumLabelSort record, @Param("example") PhotoAlbumLabelSortExample example);

    int updateByExample(@Param("record") PhotoAlbumLabelSort record, @Param("example") PhotoAlbumLabelSortExample example);

    int updateByPrimaryKeySelective(PhotoAlbumLabelSort record);

    int updateByPrimaryKey(PhotoAlbumLabelSort record);
}