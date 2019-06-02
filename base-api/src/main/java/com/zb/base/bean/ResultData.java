package com.zb.base.bean;



import com.zb.base.util.DateUtil;

import java.util.Date;

/**
 * 
 * Copyright: Copyright (c) 2018 LanRu-Caifu
 * 
 * @ClassName: ResultBean.java
 * @Description: 返回带对象数据的json格式类
 *
 * @version: v1.0.0
 * @author: 社会你哲哥
 * @date: 2018年7月17日 下午8:46:59
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月17日
 *        社会你哲哥 v1.0.0 修改原因
 */
public class ResultData<T> {
	Integer resultCode;
	String resultMsg;
	T resultData;
	Date resultTime;
	public ResultData(){
		setResultCode(200);
		setResultMsg("请求成功");
		setResultTime(DateUtil.getDate());
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	public Date getResultTime() {
		return resultTime;
	}

	public void setResultTime(Date resultTime) {
		this.resultTime = resultTime;
	}
}
