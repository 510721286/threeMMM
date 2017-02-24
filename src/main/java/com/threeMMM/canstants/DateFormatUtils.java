package com.threeMMM.canstants;

/**
 * @author xiaoyong
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: DateFormatUtils
 * @Description:
 * @author liukai
 * @date: Mar 19, 2014 10:38:29 PM
 */
public class DateFormatUtils {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(DateFormatUtils.class);

	/**
	 * yyyy-MM-dd
	 */
	public static final String ymd = "yyyy-MM-dd";

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String ymd_hm = "yyyy-MM-dd HH:mm";

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String ymd_hms = "yyyy-MM-dd HH:mm:ss";

	/**
	 * dateFormat
	 */
	private static ThreadLocal<Map<String, DateFormat>> dateFormat = new ThreadLocal<Map<String, DateFormat>>();

	public static DateFormat getDateFormat(String pattern) {
		Map<String, DateFormat> dfMap = dateFormat.get();
		if (dfMap == null) {
			dfMap = new HashMap<String, DateFormat>();
			dateFormat.set(dfMap);
		}
		if (StringUtils.isEmpty(pattern)) {
			throw new IllegalArgumentException("date format patter must not be null or empty!");
		}

		DateFormat df = dfMap.get(pattern);
		if (df == null) {
			df = new SimpleDateFormat(pattern);
			dfMap.put(pattern, df);
		}
		return dfMap.get(pattern);
	}

	public static String format(Date date, String pattern) {
		DateFormat df = getDateFormat(pattern);
		return df.format(date);
	}

	public static Date parse(String source, String pattern) {
		DateFormat df = getDateFormat(pattern);
		try {
			return df.parse(source);
		} catch (ParseException e) {
			logger.error("can't parse source: [{}] to date! catched ParseException:\n\t{}",
					new Object[] { source, e.getLocalizedMessage() });
		} catch (Exception e) {
			logger.error("can't parse source: [{}] to date! catched Exception:\n\t{}",
					new Object[] { source, e.getLocalizedMessage() });
		}
		return null;
	}

}
