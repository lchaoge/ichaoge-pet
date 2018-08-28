package com.ichaoge.pet.domain.inputParam;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by user on 2018/7/30.
 */
public class UserParam extends RequestParam implements Serializable {

    private Long id;

    private String code;

    private String openid;

    private String userName;

    private String password;

    private String phone;

    private String email;

    private String photo;

    private String question;

    private String answer;

    private Integer role;

    private String ip;

    private Integer status;

    private Long creator;

    private Date created;

    private Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"").append(id).append('\"');
        sb.append("\"userName\":\"").append(userName).append('\"');
        sb.append("\"password\":\"").append(password).append('\"');
        sb.append("\"phone\":\"").append(phone).append('\"');
        sb.append("\"email\":\"").append(email).append('\"');
        sb.append("\"photo\":\"").append(photo).append('\"');
        sb.append("\"question\":\"").append(question).append('\"');
        sb.append("\"answer\":\"").append(answer).append('\"');
        sb.append("\"role\":\"").append(role).append('\"');
        sb.append("\"ip\":\"").append(ip).append('\"');
        sb.append("\"status\":\"").append(status).append('\"');
        sb.append("\"creator\":\"").append(creator).append('\"');
        sb.append("\"created\":\"").append(created).append('\"');
        sb.append("\"modified\":\"").append(modified).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
