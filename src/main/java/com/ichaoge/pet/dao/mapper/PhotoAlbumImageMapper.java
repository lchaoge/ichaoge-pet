package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.PhotoAlbumImage;
import com.ichaoge.pet.domain.entity.PhotoAlbumImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoAlbumImageMapper {
    int countByExample(PhotoAlbumImageExample example);

    int deleteByExample(PhotoAlbumImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbumImage record);

    int insertSelective(PhotoAlbumImage record);

    List<PhotoAlbumImage> selectByExample(PhotoAlbumImageExample example);

    PhotoAlbumImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhotoAlbumImage record, @Param("example") PhotoAlbumImageExample example);

    int updateByExample(@Param("record") PhotoAlbumImage record, @Param("example") PhotoAlbumImageExample example);

    int updateByPrimaryKeySelective(PhotoAlbumImage record);

    int updateByPrimaryKey(PhotoAlbumImage record);
}