package com.zb.base.bean;

public class MyException extends Exception{
	private Integer errorCode;
	private String errorMsg;
	public MyException(Integer errorCode,String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public MyException(String errorMsg) {
		this.errorCode = 500;
		this.errorMsg = errorMsg;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return getErrorMsg();
	}
}
