package com.zb.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Copyright: Copyright (c) 2018 LanRu-Caifu
 * 
 * @ClassName: DateUtil.java
 * @Description: 时间相关的工具类
 *
 * @version: v1.0.0
 * @author: 社会你哲哥
 * @date: 2018年7月17日 下午8:05:57
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月17日
 *        社会你哲哥 v1.0.0 创建
 */
public class DateUtil {
	// 返回当前时间
	public static Date getDate() {
		Date date = new Date();
		return date;
	}

	// 返回当天时间day天后的时间，可正可负
	public static Date getAfterDate(int day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, day);
		return c.getTime();
	}

	// 计算两个date差值（分钟）
	public static long MinuteNum(Date date1, Date date2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		format.setLenient(false);
		long minutes = (date2.getTime() - date1.getTime()) / (1000 * 60);
		return minutes;
	}

	// 增加将时间串转化成时间类型
	public static Date changeDate(String strdate) throws ParseException {
		if (strdate != null) {
			// birth等用到的时间类型不需要后面的时，分，秒
			strdate = strdate + " 00:00:00";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = format.parse(strdate);
			return date;
		} else
			return null;
	}

	// 增加,测试一下jwt
	public static Date get30AfterDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 30);// 计算30天后的时间
		return c.getTime();
	}
}
