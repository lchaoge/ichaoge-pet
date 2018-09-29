package com.ichaoge.pet.domain.output;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chaoge on 2018/9/28.
 */
public class CommentFloor implements Serializable {

    private String nickName;

    private String photo;

    private Long id;

    private Long photoAlbumId;

    private Long userId;

    private Long stayUserId;

    private String stayUserName;

    private Long parentId;

    private String content;

    private Long floor;

    private String ip;

    private Integer status;

    private Long creator;

    private Date created;

    private Date modified;

    private List<CommentFloor> children;

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

    public String getStayUserName() {
        return stayUserName;
    }

    public void setStayUserName(String stayUserName) {
        this.stayUserName = stayUserName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public List<CommentFloor> getChildren() {
        return children;
    }

    public void setChildren(List<CommentFloor> children) {
        this.children = children;
    }
}
