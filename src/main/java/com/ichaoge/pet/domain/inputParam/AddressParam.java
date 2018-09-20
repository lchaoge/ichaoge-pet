package com.ichaoge.pet.domain.inputParam;

import com.ichaoge.pet.domain.inputParam.base.BaseParam;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chaoge on 2018/9/19.
 */
public class AddressParam extends BaseParam implements Serializable {
    private Long id;

    private Long userId;

    private Integer isDefault;

    private String consignee;

    private String phone;

    private String zipCode;

    private String province;

    private String city;

    private String districtn;

    private String street;

    private String address;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrictn() {
        return districtn;
    }

    public void setDistrictn(String districtn) {
        this.districtn = districtn;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        sb.append("\"userId\":\"").append(userId).append('\"');
        sb.append("\"isDefault\":\"").append(isDefault).append('\"');
        sb.append("\"consignee\":\"").append(consignee).append('\"');
        sb.append("\"phone\":\"").append(phone).append('\"');
        sb.append("\"zipCode\":\"").append(zipCode).append('\"');
        sb.append("\"province\":\"").append(province).append('\"');
        sb.append("\"city\":\"").append(city).append('\"');
        sb.append("\"districtn\":\"").append(districtn).append('\"');
        sb.append("\"street\":\"").append(street).append('\"');
        sb.append("\"address\":\"").append(address).append('\"');
        sb.append("\"status\":\"").append(status).append('\"');
        sb.append("\"creator\":\"").append(creator).append('\"');
        sb.append("\"created\":\"").append(created).append('\"');
        sb.append("\"modified\":\"").append(modified).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
