package com.ichaoge.pet.domain.entity.enums;

/**
 * oa 审批状态
 *
 */
public enum OaStatusEnums {
//    0提交， 1驳回 2已审批 3未提交
    SUBMITTED(0, "已提交"),
    REJECT(1, "驳回"),
    APPROVALED(2, "已审批"),
    UNSUBMITTED(3, "未提交");

    private int value;
    private String desc;

    private OaStatusEnums(int value, String desc) {
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
