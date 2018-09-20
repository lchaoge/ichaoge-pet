package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.entity.PhotoAlbum;
import com.ichaoge.pet.domain.entity.PhotoAlbumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chaoge on 2018/9/20.
 */
public interface PhotoAlbumServiceI {
    int countByExample(PhotoAlbumExample example);

    int deleteByExample(PhotoAlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbum record);

    int insertSelective(PhotoAlbum record);

    List<PhotoAlbum> selectByExampleWithBLOBs(PhotoAlbumExample example);

    List<PhotoAlbum> selectByExample(PhotoAlbumExample example);

    PhotoAlbum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PhotoAlbum record);

    int updateByPrimaryKeyWithBLOBs(PhotoAlbum record);

    int updateByPrimaryKey(PhotoAlbum record);
}
