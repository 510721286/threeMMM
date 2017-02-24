/**
 * 
 */
package com.threeMMM.service;

import java.util.Date;

/**
 * @author xiaoyong
 */
public interface IGoldService {
	public void goldtest(String name);

	/**
	 * 推荐预收益
	 * 
	 * @param name
	 * @return
	 */
	public String goldTJZByProType(String name, String orderId, String caseProductId, Date time);

	/**
	 * 参与预收益
	 * 
	 * @param name
	 */
	public String goldCYZByProType(String name, String uid, String relaID, String level, String wxOrderID,
			Integer directSellingMoney);

	/**
	 * 通过状态控制推荐值
	 * 
	 * @param name
	 */
	public String updateTJZByProType(String name, String orderID, Integer targetType);

	/**
	 * 通过状态控制参与值
	 * 
	 * @param name
	 */
	public String updateCYZByProType(String name, Integer profitType, Long directSellingID);

}
