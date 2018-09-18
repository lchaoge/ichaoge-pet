package com.ichaoge.pet.domain.inputParam;

import java.io.Serializable;

/**
 * Created by chaoge on 2018/9/18.
 */
public class DecodeParam  extends RequestParam implements Serializable {

    private String code;

    private String encrypdata;

    private String ivdata;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncrypdata() {
        return encrypdata;
    }

    public void setEncrypdata(String encrypdata) {
        this.encrypdata = encrypdata;
    }

    public String getIvdata() {
        return ivdata;
    }

    public void setIvdata(String ivdata) {
        this.ivdata = ivdata;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":\"").append(code).append('\"');
        sb.append("\"encrypdata\":\"").append(encrypdata).append('\"');
        sb.append("\"ivdata\":\"").append(ivdata).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
