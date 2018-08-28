package com.ichaoge.pet.common.constant;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 编码常量
 * <p>
 * User: gaofx
 * Date: 15-2-3
 * Time: 下午3:09
 */
public class CommConst {

    public static String MANDT_BJ = "300";
    public static String MANDT_HD = "305";
    public static String MANDT_NX = "307";


    /**
     * 员工编号
     */
    public static final String USERNO = "userNo";

    /**
     * 大区号
     */
    public static final String KEY_MANDT = "mandt";

    /**
     * 门店号
     */
    public static final String KEY_SITENO = "siteNo";

    /**
     * 门店名
     */
    public static final String KEY_SITENAME = "siteName";

    /**
     * 业态
     */
    public static final String KEY_INDU = "indu";

    /**
     * OA审批单类型
     */
    public static final String OA_FEE_TYPE = "3";

    /**
     * OA审批单类型
     */
    public static final String OA_AREA_TYPE = "1";

    /**
     * OA审批单类型
     */
    public static final String OA_RATE_TYPE = "2";

    /**
     * OA审批单类型
     */
    public static final String OA_SCORE_TYPE = "4";

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

    /**
     * oa回调
     */
    public static final String CALL_BACK_AREA_LOAD = "/wumart/partner/area/acreaDetail";

    /**
     * oa回调
     */
    public static final String CALL_BACK_RATE_LOAD = "/wumart/partner/rate/rateDetail";

    /**
     * oa回调
     */
    public static final String CALL_BACK_FEE_LOAD = "/wumart/partner/Fee/feeDetail";

    /**
     * oa回调
     */
    public static final String CALL_BACK_SCORE_LOAD = "/wumart/partner/employeescore/scoreDetail";

    /**
     * oa回调
     */
    public static final String CALL_BACK_AREA_SAVA = "/wumart/partner/area/areaSave";

    /**
     * oa回调
     */
    public static final String CALL_BACK_RATE_SAVA = "/wumart/partner/rate/rateSave";

    /**
     * oa回调
     */
    public static final String CALL_BACK_FEE_SAVA = "/wumart/partner/Fee/feeSave";

    /**
     * oa回调
     */
    public static final String CALL_BACK_SCORE_SAVA = "/wumart/partner/employeescore/scoreSave";

    /**
     * oa回调
     */
    public static final String CALL_BACK_URL_SAVA = "saveurl";

    /**
     * oa回调
     */
    public static final String CALL_BACK_URL_LOAD = "loadurl";

    /**
     * oa参数
     */
    public static final String APP_SUBJECT = "AppSubject";
    /**
     * oa参数
     */
    public static final String ST_OLD_AREA = "StOldArea";
    /**
     * oa参数
     */
    public static final String ST_ID = "StId";

    /**
     * oa参数
     */
    public static final String ST_TOTAL_AREA = "StTotalArea";

    /**
     * oa参数
     */
    public static final String STSITE_NO = "StSiteNo";

    /**
     * oa参数
     */
    public static final String APP_INDEX = "AppIndex";

    /**
     * oa参数
     */
    public static final String OA_SUBMITTER = "StSubmitter";

    /**
     * oa参数
     */
    public static final String NEXT = "next";

    /**
     * oa参数
     */
    public static final String BACK = "back";

    /**
     * oa参数
     */
    public static final String END_FLOW = "FlowEndNode";

    /**
     * oa参数
     */
    public static final String OA_DATABASE = "Application/DigiFlowPartnerCfg.nsf";

    /**
     * oa参数-评分
     */
    public static final String OA_DATABASE_SCORE = "application/digiflowempappraisal.nsf";

    /**
     * OA默认审批用户
     */
    public static final String ADMIN = "admin";

    /**
     * OA默认审批用户
     */
    public static final String HHR = "hhr";

    /**
     * OA默认审批用户 （人力绩效组公共OA）
     */
    public static final String JTHRJX = "jthrjx";

    /**
     * 综合费用合伙人组编号
     */
    public static final String P00 = "P00";

    /**
     * 最终审批
     */
    public static final String FINAL_AUDIT_STR = "最终审批";

    /**
     * 年月批次开始编号
     */
    public static final String YEAR_MONTH_BRANCH_START_NO = "0001";
    /**
     * 合伙人相关接口查询-员工编号
     */
    public static final String HHR_PERNR = "pernr";

    /**
     * 评分系统，花名册剔除员工子组
     */
    public static final List<String> EXCLUDE_PERSK = Lists.newArrayList("A7","A8","A9","B4","B5","B6","U1","U2","U3","U4","U9");

    /**
     * 评分系统，花名册剔除岗位名称
     */
    public static final List<String> EXCLUDE_POSITION = Lists.newArrayList("O2O负责人","多点负责人","拣货员","配送员");
}
