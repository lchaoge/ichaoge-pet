package com.ichaoge.pet.service.iservice;

import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.entity.PhotoAlbum;
import com.ichaoge.pet.domain.entity.PhotoAlbumExample;
import com.ichaoge.pet.domain.inputParam.PhotoAlbumParam;
import com.ichaoge.pet.domain.inputParam.UserParam;

import java.util.List;

/**
 * Created by chaoge on 2018/9/20.
 */
public interface PhotoAlbumServiceI {
    int countByExample(PhotoAlbumParam example);

    int deleteByExample(PhotoAlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbum record);

    int insertSelective(PhotoAlbum record);

    List<PhotoAlbum> selectByExampleWithBLOBs(PhotoAlbumExample example);

    List<PhotoAlbum> selectByExample(PhotoAlbumParam example);

    PhotoAlbum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PhotoAlbum record);

    int updateByPrimaryKeyWithBLOBs(PhotoAlbum record);

    int updateByPrimaryKey(PhotoAlbum record);

    // 分页查询
    Pagination queryAllPage(PhotoAlbumParam param);
}
