package com.ichaoge.pet.common.entity;

/**
 * Created by chaoge on 2018/8/30.
 */
public class Tree {
    private String id;
    private String parentId;
    private String name;
    private String describes;
    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Tree [id=" + id + ", parentId=" + parentId + ", name=" + name +", describes=" + describes +", photo=" + photo + "]";
    }
}
