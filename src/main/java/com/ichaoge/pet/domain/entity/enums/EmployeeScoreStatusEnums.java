package com.ichaoge.pet.domain.entity.enums;

/**
 * 员工提交审批stutes
 *
 */
public enum EmployeeScoreStatusEnums {
    UNSUBMITTED(0, "未提交"),
    SUBMITTED(1, "已提交"),
    APPROVALED(2, "已审批");

    private int value;
    private String desc;

    private EmployeeScoreStatusEnums(int value, String desc) {
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
