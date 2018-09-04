package com.ichaoge.pet.domain.inputParam;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/8/28.
 */
public class UserInfoParam extends RequestParam implements Serializable {

    private Long userId;

    private String photo;

    private Integer sex;

    private String nickName;

    private String address;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":\"").append(userId).append('\"');
        sb.append("\"photo\":\"").append(photo).append('\"');
        sb.append("\"sex\":\"").append(sex).append('\"');
        sb.append("\"nickName\":\"").append(nickName).append('\"');
        sb.append("\"address\":\"").append(address).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
