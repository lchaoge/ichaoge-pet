package com.ichaoge.pet.domain.entity.enums;

/**
 * 用户角色
 * 角色 普通用户=1，管理员=0
 */
public enum UserRoleEnums {

    SUBMITTED(1, "普通用户"),
    REJECT(0, "管理员");

    private int value;
    private String desc;

    private UserRoleEnums(int value, String desc) {
        this.desc = desc;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
