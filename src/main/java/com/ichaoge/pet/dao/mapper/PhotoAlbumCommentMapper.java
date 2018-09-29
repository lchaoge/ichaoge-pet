package com.ichaoge.pet.dao.mapper;

import com.ichaoge.pet.domain.entity.PhotoAlbumComment;
import com.ichaoge.pet.domain.entity.PhotoAlbumCommentExample;
import java.util.List;

import com.ichaoge.pet.domain.output.CommentFloor;
import org.apache.ibatis.annotations.Param;

public interface PhotoAlbumCommentMapper {
    int countByExample(PhotoAlbumCommentExample example);

    int deleteByExample(PhotoAlbumCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoAlbumComment record);

    int insertSelective(PhotoAlbumComment record);

    List<PhotoAlbumComment> selectByExampleWithBLOBs(PhotoAlbumCommentExample example);

    List<PhotoAlbumComment> selectByExample(PhotoAlbumCommentExample example);

    PhotoAlbumComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhotoAlbumComment record, @Param("example") PhotoAlbumCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") PhotoAlbumComment record, @Param("example") PhotoAlbumCommentExample example);

    int updateByExample(@Param("record") PhotoAlbumComment record, @Param("example") PhotoAlbumCommentExample example);

    int updateByPrimaryKeySelective(PhotoAlbumComment record);

    int updateByPrimaryKeyWithBLOBs(PhotoAlbumComment record);

    int updateByPrimaryKey(PhotoAlbumComment record);

    // 查询当前评论的最后一个楼
    Long selectFloorByPhotoAlbumId(Long photoAlbumId);

    // 根据写真集ID查询写真集所有楼层
    List<CommentFloor> selectAllFloor(Long photoAlbumId);

    // 根据楼层和写真集ID查询单个楼层
    List<CommentFloor> selectOneFloor(CommentFloor commentFloor);

}