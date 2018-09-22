package com.ichaoge.pet.domain.output;

import com.ichaoge.pet.domain.entity.LabelSort;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/9/22.
 */
public class LabelSortOutput implements Serializable {
    private Long id;

    private Integer type;

    private String title;

    private String describe;

    private String photo;

    private Integer status;

    private Long creator;

    private Date created;

    private Date modified;

    private boolean checked; // 是否选中

    public LabelSortOutput(LabelSort labelSort) {
        this.id = labelSort.getId();
        this.type = labelSort.getType();
        this.title = labelSort.getTitle();
        this.describe = labelSort.getDescribe();
        this.photo = labelSort.getPhoto();
        this.status = labelSort.getStatus();
        this.creator = labelSort.getCreator();
        this.created = labelSort.getCreated();
        this.modified = labelSort.getModified();
        this.checked = false;  // 默认不选中

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
