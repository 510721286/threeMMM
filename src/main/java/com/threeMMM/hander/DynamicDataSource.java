package com.threeMMM.hander;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.threeMMM.canstants.DynamicDataSourceGlobal;

/**
 * Created by IDEA User: mashaohua Date: 2016-07-14 10:56 Desc: 动态数据源切换
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);
	private Object yuejiaDataSource; // YUEJIA数据源

	private Object jianghaoDataSource; // JIANGHAO数据源

	@Override
	public void afterPropertiesSet() {
		if (this.yuejiaDataSource == null) {
			throw new IllegalArgumentException("Property 'yuejiaDataSource' is required");
		}
		setDefaultTargetDataSource(yuejiaDataSource);
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DynamicDataSourceGlobal.YUEJIA.name(), yuejiaDataSource);
		if (jianghaoDataSource != null) {
			targetDataSources.put(DynamicDataSourceGlobal.JIANGHAO.name(), jianghaoDataSource);
		}
		setTargetDataSources(targetDataSources);
		super.afterPropertiesSet();
	}

	@Override
	protected Object determineCurrentLookupKey() {

		DynamicDataSourceGlobal dynamicDataSourceGlobal = DynamicDataSourceHolder.getDataSource();

		if (dynamicDataSourceGlobal == null || dynamicDataSourceGlobal == DynamicDataSourceGlobal.YUEJIA) {
			LOGGER.info("使用YUEJIA库");
			return DynamicDataSourceGlobal.YUEJIA.name();
		}
		LOGGER.info("使用JIANGHAO库");
		return DynamicDataSourceGlobal.JIANGHAO.name();
	}

	public Object getYuejiaDataSource() {
		return yuejiaDataSource;
	}

	public void setYuejiaDataSource(Object yuejiaDataSource) {
		this.yuejiaDataSource = yuejiaDataSource;
	}

	public Object getJianghaoDataSource() {
		return jianghaoDataSource;
	}

	public void setJianghaoDataSource(Object jianghaoDataSource) {
		this.jianghaoDataSource = jianghaoDataSource;
	}

	
}