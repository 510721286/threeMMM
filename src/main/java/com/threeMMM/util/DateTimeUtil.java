/**
 * 
 */
package com.threeMMM.util;

import java.util.Calendar;
import java.util.Date;

import com.threeMMM.canstants.DateFormatUtils;

/**
 * @author xiaoyong
 */
public class DateTimeUtil {

	/**
	 * @Title: getTodayAndYesterday
	 * @Description: 获取今天和几天前 的开始时间
	 * @return: Date[]
	 * @author: jing.huang
	 * @date: 2014年12月30日 下午8:06:58
	 */
	public static Date[] getTodayAndYesterday(int interval) {
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - interval);
		Date yesterday = calendar.getTime();

		String ymdYesterday = DateFormatUtils.format(yesterday, DateFormatUtils.ymd);
		String ymdToday = DateFormatUtils.format(today, DateFormatUtils.ymd);

		Date beginTime = DateFormatUtils.parse(ymdYesterday + " 00:00:00", DateFormatUtils.ymd_hms);
		Date endTime = DateFormatUtils.parse(ymdToday + " 00:00:00", DateFormatUtils.ymd_hms);

		return new Date[] { beginTime, endTime };
	}
	
	public static Date[] getTodayAndTomorrow(int interval) {
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + interval);
		Date tomorrow = calendar.getTime();

		String tomorrowday = DateFormatUtils.format(tomorrow, DateFormatUtils.ymd);
		String ymdToday = DateFormatUtils.format(today, DateFormatUtils.ymd);

		Date tomorrowTime = DateFormatUtils.parse(tomorrowday + " 00:00:00", DateFormatUtils.ymd_hms);
		Date todayTime = DateFormatUtils.parse(ymdToday + " 00:00:00", DateFormatUtils.ymd_hms);

		return new Date[] { todayTime, tomorrowTime };
	}

}
