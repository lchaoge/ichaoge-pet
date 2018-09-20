package com.ichaoge.pet.common.constant;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by chaoge on 2018/8/28.
 * 编码常量
 */
public class CommConst {

    /**
     * 分页（每页数量）
     */
    public static final Integer PAGE_SIZE = 10;

    /**
     * 当前页（默认）
     */
    public static final Integer CURRENT_PAGE = 1;

    /**
     * 默认全部查询条件
     */
    public static final Integer DEFULT_QUERY_CONDITION = -1;

    /**
     * 默认全部查询条件
     */
    public static final String DEFULT_BUDGETID_QUERY_CONDITION = "-1";

    /**
     * 一天
     */
    public static final Integer ONE_DAY = 1;

    /**
     * 大数据过滤条件前缀
     */
    public static final String BIGDATA_PREFIX_CONDITION = "COWMC";

    /**
     * 大数据过滤条件后缀
     */
    public static final String BIGDATA_SUFFIX_CONDITION = "1000";

    /**
     * 时间排序条件
     */
    public static final String ORDER_CONDITION = "created";

    /**
     * 降序
     */
    public static final String DESC = "DESC";

    /**
     * 默认审批人id
     */
    public static final Integer DEFULT_AUDITORID = -1;

    /**
     * 默认oaid
     */
    public static final String DEFULT_OAID = "";

    /**
     * 删除标志(1:删除，0：正常）
     */
    public static final Integer DELETE_FLAG = 0;

    /**
     * oaid更新条件
     */
    public static final String DELETE_OAID_UPDATE_CONDITION = "-1";

    /**
     * 合伙人费用变更单
     */
    public static final String RATE_CHANGE_TITEL = "%s提交了合伙人拆分比例变更申请";

    /**
     * 合伙人费用变更单
     */
    public static final String FEE_CHANGE_TITEL = "%s提交了合伙人费用变更申请";

    /**
     * 员工评分申请
     */
    public static final String SCORE_CHANGE_TITEL = "%s提交了员工评分申请";

    /**
     * 合伙人费用变更单
     */
    public static final String AREA_CHANGE_TITEL = "%s提交了合伙人门店面积变更申请";

    /**
     * 提交
     */
    public static final String OA_DEFULT = "-1";

    /**
     * 提交
     */
    public static final String OA_SUBMIT = "0";

    /**
     * 驳回
     */
    public static final String OA_REJECT = "1";

    /**
     * 已审批
     */
    public static final String OA_AUDIT = "2";

    /**
     * 审批人
     */
    public static final String AUDITOR_FIRST = "oneLevelAuditor";
    /**
     * 审批人
     */
    public static final String AUDITOR_SECOND = "twoLevelAuditor";
    /**
     * 审批人
     */
    public static final String AUDITOR_THIRD = "threeLevelAuditor";
    /**
     * 审批人
     */
    public static final String AUDITOR_FOURTH = "fourLevelAuditor";
    /**
     * 审批人
     */
    public static final String AUDITOR_FIFTH = "fiveLevelAuditor";
    /**
     * 审批人
     */
    public static final String AUDITOR_SIXTH = "sixLevelAuditor";
    /**
     * 开发环境
     */
    public static final String PROFILE_DEV = "dev";
    /**
     * 测试环境
     */
    public static final String PROFILE_QA = "qa";

    /**
     * 生产环境
     */
    public static final String PROFILE_PRODUCT = "product";

    /**
     * 预生产环境
     */
    public static final String PROFILE_PREPRODUCT = "preproduct";


}
