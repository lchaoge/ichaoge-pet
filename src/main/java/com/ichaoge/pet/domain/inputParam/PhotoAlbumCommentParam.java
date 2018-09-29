package com.ichaoge.pet.domain.inputParam;

import com.ichaoge.pet.domain.entity.PhotoAlbumComment;
import com.ichaoge.pet.domain.inputParam.base.BaseParam;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/9/27.
 */
public class PhotoAlbumCommentParam extends BaseParam implements Serializable {

    private Long id;

    private Long photoAlbumId;

    private Long userId;

    private Long stayUserId;

    private Long parentId;

    private Long floor;

    private String ip;

    private Integer status;

    private Long creator;

    private Date created;

    private Date modified;

    private String content;

    public PhotoAlbumCommentParam(){}

    public PhotoAlbumCommentParam(PhotoAlbumComment photoAlbumComment) {
        this.id = photoAlbumComment.getId();
        this.photoAlbumId = photoAlbumComment.getPhotoAlbumId();
        this.userId = photoAlbumComment.getUserId();
        this.stayUserId = photoAlbumComment.getStayUserId();
        this.parentId = photoAlbumComment.getParentId();
        this.floor = photoAlbumComment.getFloor();
        this.ip = photoAlbumComment.getIp();
        this.status = photoAlbumComment.getStatus();
        this.creator = photoAlbumComment.getCreator();
        this.created = photoAlbumComment.getCreated();
        this.modified = photoAlbumComment.getModified();
        this.content = photoAlbumComment.getContent();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"").append(id).append('\"');
        sb.append("\"photoAlbumId\":\"").append(photoAlbumId).append('\"');
        sb.append("\"userId\":\"").append(userId).append('\"');
        sb.append("\"stayUserId\":\"").append(stayUserId).append('\"');
        sb.append("\"parentId\":\"").append(parentId).append('\"');
        sb.append("\"floor\":\"").append(floor).append('\"');
        sb.append("\"ip\":\"").append(ip).append('\"');
        sb.append("\"content\":\"").append(content).append('\"');
        sb.append("\"status\":\"").append(status).append('\"');
        sb.append("\"creator\":\"").append(creator).append('\"');
        sb.append("\"created\":\"").append(created).append('\"');
        sb.append("\"modified\":\"").append(modified).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(Long photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStayUserId() {
        return stayUserId;
    }

    public void setStayUserId(Long stayUserId) {
        this.stayUserId = stayUserId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getFloor() {
        return floor;
    }

    public void setFloor(Long floor) {
        this.floor = floor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
