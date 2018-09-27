package com.ichaoge.pet.domain.inputParam;

import com.ichaoge.pet.domain.inputParam.base.BaseParam;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/9/27.
 */
public class PetParam extends BaseParam implements Serializable {

    private Long id;

    private Long cardNo;

    private Long userId;

    private Long petSortId;

    private Integer isCurrent;

    private String nickname;

    private String photo;

    private String sex;

    private String weight;

    private String describes;

    private String sterilization;

    private Date birthDate;

    private Date homeDate;

    private Integer status;

    private Long creator;

    private Date created;

    private Date modified;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"").append(id).append('\"');
        sb.append("\"cardNo\":\"").append(cardNo).append('\"');
        sb.append("\"userId\":\"").append(userId).append('\"');
        sb.append("\"petSortId\":\"").append(petSortId).append('\"');
        sb.append("\"isCurrent\":\"").append(isCurrent).append('\"');
        sb.append("\"nickname\":\"").append(nickname).append('\"');
        sb.append("\"photo\":\"").append(photo).append('\"');
        sb.append("\"sex\":\"").append(sex).append('\"');
        sb.append("\"weight\":\"").append(weight).append('\"');
        sb.append("\"describes\":\"").append(describes).append('\"');
        sb.append("\"sterilization\":\"").append(sterilization).append('\"');
        sb.append("\"birthDate\":\"").append(birthDate).append('\"');
        sb.append("\"homeDate\":\"").append(homeDate).append('\"');
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

    public Long getCardNo() {
        return cardNo;
    }

    public void setCardNo(Long cardNo) {
        this.cardNo = cardNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPetSortId() {
        return petSortId;
    }

    public void setPetSortId(Long petSortId) {
        this.petSortId = petSortId;
    }

    public Integer getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getSterilization() {
        return sterilization;
    }

    public void setSterilization(String sterilization) {
        this.sterilization = sterilization;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHomeDate() {
        return homeDate;
    }

    public void setHomeDate(Date homeDate) {
        this.homeDate = homeDate;
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
}
