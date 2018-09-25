package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.base.Pagination;
import com.ichaoge.pet.domain.entity.PhotoAlbum;
import com.ichaoge.pet.domain.entity.PhotoAlbumExample;
import java.util.List;

import com.ichaoge.pet.domain.inputParam.PhotoAlbumParam;
import org.apache.ibatis.annotations.Param;

public interface PhotoAlbumMapper {
    int countByExample(PhotoAlbumExample example);

    int deleteByExample(PhotoAlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbum record);

    int insertSelective(PhotoAlbum record);

    List<PhotoAlbum> selectByExampleWithBLOBs(PhotoAlbumExample example);

    List<PhotoAlbum> selectByExample(PhotoAlbumExample example);

    PhotoAlbum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhotoAlbum record, @Param("example") PhotoAlbumExample example);

    int updateByExampleWithBLOBs(@Param("record") PhotoAlbum record, @Param("example") PhotoAlbumExample example);

    int updateByExample(@Param("record") PhotoAlbum record, @Param("example") PhotoAlbumExample example);

    int updateByPrimaryKeySelective(PhotoAlbum record);

    int updateByPrimaryKeyWithBLOBs(PhotoAlbum record);

    int updateByPrimaryKey(PhotoAlbum record);

    // 分页查询
    Pagination queryAllPage(PhotoAlbumParam param);
}