package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.PhotoAlbumImage;
import com.ichaoge.pet.domain.entity.PhotoAlbumImageExample;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumImageParam;

import java.util.List;

/**
 * Created by chaoge on 2018/9/20.
 */
public interface PhotoAlbumImageServiceI {
    int countByExample(PhotoAlbumImageExample example);

    int deleteByExample(PhotoAlbumImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbumImage record);

    int insertSelective(PhotoAlbumImage record);

    List<PhotoAlbumImage> selectByExample(PhotoAlbumImageParam example);

    PhotoAlbumImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PhotoAlbumImage record);

    int updateByPrimaryKey(PhotoAlbumImage record);
}
