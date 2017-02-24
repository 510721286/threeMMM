package com.threeMMM.hander;

import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.threeMMM.canstants.DynamicDataSourceGlobal;
import com.threeMMM.controller.Canstants;

/**
 * 
 * @author xiaoyong
 */
public class DynamicDataSourceAspect {

	private static final Logger logger = Logger.getLogger(DynamicDataSourceAspect.class);

	public void pointCut() {
	};

	public void before(JoinPoint point) {
		String typeValue = (String) point.getArgs()[0];
		JSONObject json=JSONObject.parseObject(typeValue);
		String DBtype = (String)json.get("name");
		System.out.println("测试进入方法,获取到参数="+DBtype);
		if (Canstants.DB_TYPE_YUEJIA.equals(DBtype)) {
			logger.info("选择YUEJIA数据库并且默认为写事物");
			DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.YUEJIA);
			return;
		}
		DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.JIANGHAO);
		logger.info("选择JIANGHAO数据库并且默认为写事物");

	}

	public void after(JoinPoint point) {
		DynamicDataSourceHolder.clearDataSource();
	}
}