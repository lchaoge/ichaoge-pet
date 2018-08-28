package com.ichaoge.pet.domain.base;

import java.io.Serializable;

public class ResultModel<E> implements Serializable{

	private static final long serialVersionUID = 7741968134262949185L;

	//错误码
	private String code;
	
	//接口调用是否成功
	private boolean isSuccess;
	
	//返回提示信息
	private String message;
	
	//返回数据
	private E model;
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("code=").append(code).append(",isSuccess=").append(isSuccess)
		.append(message == null ? "" : ",message="+message);
		return result.toString();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public E getModel() {
		return model;
	}

	public void setModel(E model) {
		this.model = model;
	}

}
