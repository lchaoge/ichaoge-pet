package com.ichaoge.pet.domain.baseenum;



public enum ResulstCodeEnum {
	//本系统定义code区间000-999
	SERVICE_SUCESS("000", "调用服务成功"),
	SERVICE_EXCEPTION("001", "内部服务异常"),
	PARAM_EMPTY_OR_ERROR("002", "参数为空或参数不正确"),
	DATA_EMPTY("003", "业务数据为空(未查询到数据)"),
	DATA_EXIST("004", "业务数据已经存在"),
	CAPTCHA_INVALID("005", "验证码无效"),
	CARPORT_OCCUPY("006", "该车为已被占用"),
	RES_NUM_NOT_FOUND("007", "该预约号不存在"),
	SUPPLIER_GROUP("008", "供应商组登陆/承运商登陆，无法获取关联承运商"),
	CARRIER_GROUP_ERROR("010", "获取到多个承运商"),
	LOGIN_ERROR("010", "获取登录信息失败"),
	STATUS_DELAY_ERROR("011", "状态数据过期, 请刷新后重试"),
	NONE_CONSTRAINT("012" , "未配置预约参数"),
	FILE_TYPE_ERROR("013" , "文件类型不正确"),

	//定义第三方调用code
	REMOTE_SERVICE_SUCESS("100", "调用远程服务成功"),
	REMOTE_SERVICE_FAILD("101", "调用远程服务失败");


	private String code;
	
	private String codeDesc;

	private ResulstCodeEnum(String code, String codeDesc) {
		this.code = code;
		this.codeDesc = codeDesc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	

	/**
	 * 检测值是否在枚举中
	 * @param value
	 * @return
	 */
	public static boolean isExist(String code){
		boolean isExist = false;
		
		if(code != null){
			for(ResulstCodeEnum em: ResulstCodeEnum.values()){
				if(em.getCode().equals(code)){
					isExist = true;
					break;
				} else {
					isExist = false;
				}
			}
		}
		
		return isExist;
	}
	
	public static String getName(String code){
		if (code == null) return ""; 
		String name = "";
		for(ResulstCodeEnum em: ResulstCodeEnum.values()){
			if(em.getCode().equals(code)){
				name = em.getCodeDesc();
				break;
			} else {
				name = "";
			}
		}
		
		return name;
	}
}
