package com.threeMMM.hander;

import com.threeMMM.canstants.DynamicDataSourceGlobal;
/**
 * 
 * @author xiaoyong
 *
 */

public final class DynamicDataSourceHolder {

	private static final ThreadLocal<DynamicDataSourceGlobal> holder = new ThreadLocal<DynamicDataSourceGlobal>();

	private DynamicDataSourceHolder() {
		//
	}

	public static void putDataSource(DynamicDataSourceGlobal dataSource) {
		holder.set(dataSource);
	}

	public static DynamicDataSourceGlobal getDataSource() {
		return holder.get();
	}

	public static void clearDataSource() {
		holder.remove();
	}

}