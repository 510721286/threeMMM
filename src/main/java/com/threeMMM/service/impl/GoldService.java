/**
 * 
 */
package com.threeMMM.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeMMM.commom.utils.JsonUtil;
import com.threeMMM.controller.Canstants;
import com.threeMMM.core.Dao.IEntityPersist;
import com.threeMMM.core.Dao.IEntityQueryFactory;
import com.threeMMM.model.CaseProduct;
import com.threeMMM.model.Customer;
import com.threeMMM.model.CustomerRela;
import com.threeMMM.model.DirectSelling;
import com.threeMMM.model.MoneyChange;
import com.threeMMM.model.Order;
import com.threeMMM.model.OrderCharge;
import com.threeMMM.model.WxOrder;
import com.threeMMM.service.IGoldService;


/**
 * @author xiaoyong
 */
@Service
public class GoldService implements IGoldService {

	Logger logger = Logger.getLogger(GoldService.class);
	@Autowired
	protected IEntityQueryFactory entityQueryFactory;

	@Autowired
	protected IEntityPersist entityPersist;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.threeMMM.service.IGoldService#test()
	 */
	@Override
	public void goldtest(String name) {
		System.out.println("已经进来啦");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.threeMMM.service.IGoldService#goldYuejia() 计算推荐值且冻结状态
	 */
	@Override
	public String goldTJZByProType(String name, String orderId, String caseProductId, Date time) {
		if (Canstants.DB_TYPE_YUEJIA.equals(name)) {

			return "";
		} else {
			return saveOrderCharge(orderId, caseProductId, time);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.threeMMM.service.IGoldService#goldYuejia() 计算参与值且冻结装
	 */
	@Override
	public String goldCYZByProType(String name, String uid, String relaID, String level, String wxOrderID,
			Integer directSellingMoney) {
		if (Canstants.DB_TYPE_YUEJIA.equals(name)) {

			return "";
		}
		return saveDirectSelling(uid, relaID, level, wxOrderID, directSellingMoney);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.threeMMM.service.IGoldService#updateTJZByProType(java.lang.String)
	 * 通过修改状态位来控制推荐值
	 */
	@Override
	public String updateTJZByProType(String name, String orderID, Integer targetType) {
		if (Canstants.DB_TYPE_YUEJIA.equals(name)) {

			return "";
		} else {
			return updateTJZ(orderID, targetType);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.threeMMM.service.IGoldService#updateCYZByProType(java.lang.String)
	 * 通过修改状态控制参与值
	 */
	@Override
	public String updateCYZByProType(String name, Integer profitType, Long directSellingID) {
		if (Canstants.DB_TYPE_YUEJIA.equals(name)) {

			return "";
		}
		updateCyzStatus(profitType, directSellingID);
		return "";
	}

	/**
	 * 推荐的预收益 WeiXinController line 334
	 * 
	 * @param orderId
	 * @param upOpenid
	 * @param time
	 * @param dyMoney
	 * @return
	 */ 
	private String saveOrderCharge(String orderId, String caseProductId, Date time) {
		WxOrder  wxOrderInfo= entityQueryFactory.createQuery(WxOrder.class).eq("id", Long.parseLong(orderId), true).get();
		CaseProduct caseProduct = entityQueryFactory.createQuery(CaseProduct.class).eq("id", caseProductId, true).get();
		Integer dyMoney = getCountRebate(caseProduct.getRebate(), caseProduct.getDyRate(), wxOrderInfo.getProduct_count());
		String upOpenid=wxOrderInfo.getUpOpenid();//操作人 openid
		String result = "false";
		OrderCharge oc = entityQueryFactory.createQuery(OrderCharge.class).eq("orderNo", orderId, true)
				.eq("orderType", Canstants.ORDERTYPE_OF_DY_ORDERCHARGE, true).get();
		if (null == oc) {
			oc = new OrderCharge();
			oc.setOrderTime(time);
			oc.setOrderType(Canstants.ORDER_TYPE_FROZEN);
			oc.setStatus(Canstants.STATUS_OK);
			oc.setMuid(upOpenid);
			oc.setOrderNo(orderId);
			oc.setPayNum(dyMoney);
			oc.setDescription("代言收益");
			entityPersist.save(oc);
			result = "true";
		}
		return JsonUtil.toJson(result);
	}

	/**
	 * 推荐值变更：将推荐值会员收益的状态有冻结状态改为不可用状态或发放给代言人 同时给推荐人推送消息
	 * 
	 * @param order
	 *            订单
	 * @param profitType
	 *            收益值操作类型：1、收益发放冻结状态加入到可提现余额 2、收益回收即冻结状态变成不可用状态
	 * @param srcType
	 *            当前状态码
	 * @param targetType
	 *            目标状态码
	 * @return
	 */
	private String updateTJZ(String orderID, Integer targetType) {
		String result = "false";
		try{
		OrderCharge orderCharge = entityQueryFactory.createQuery(OrderCharge.class)
				.eq("id", Long.parseLong(orderID), true).get();
		orderCharge.setOrderType(targetType);
		orderCharge.setUpdateTime(new Date());
		entityPersist.update(orderCharge);
		result= "true";
		}catch(Exception e ){
			logger.error("修改推荐值状态发生错误:" + e.getStackTrace());
		}
		return JsonUtil.toJson(result);
	}

	/**
	 * 通过状态来控制参与的预收益 serviceController changeCyzStatus 3064
	 * 
	 * @return
	 */
	private String updateCyzStatus(Integer profitType, Long directSellingID) {
		String result = "false";
		try{
		DirectSelling directSelling = entityQueryFactory.createQuery(DirectSelling.class)
				.eq("id", directSellingID, true).get();
		directSelling.setOrderType(profitType);
		directSelling.setUpdateTime(new Date());
		entityPersist.update(directSelling);
		result= "true";
		}catch(Exception e ){
			logger.error("修改推荐值状态发生错误:" + e.getStackTrace());
		}
		return JsonUtil.toJson(result);
	}

	//
	// /**
	// * 余额账户流水进出记录
	// *
	// * @param customer
	// * 用户对象
	// * @param changeMoney
	// * 当前变更金额
	// * @param optId
	// * 对应平台操作流水序列id
	// * @param changeType
	// * 变更类型，1支出，2收入
	// * @param moneyType
	// * 变动渠道，1提现，2推荐值，3参与值
	// */
	public void saveMoneyChangeRecord(Customer customer, int changeMoney, String optId, int changeType, int moneyType) {
		MoneyChange moneyChangeBean = new MoneyChange();
		moneyChangeBean.setOpenid(customer.getOpenId());
		moneyChangeBean.setOptTime(new Date());
		moneyChangeBean.setChangType(changeType);// 变动类型，1支出，2收入
		moneyChangeBean.setMoneyType(moneyType);// 变动渠道，1提现，2推荐值，3参与值
		moneyChangeBean.setBalance(customer.getTotalPoint());// 操作后的账户余额
		moneyChangeBean.setChangeMoney(changeMoney);// 变动金额
		moneyChangeBean.setAppid(customer.getAppid());
		String remark = "";
		if (moneyType == 1) {
			remark = "提现处理";
		} else if (moneyType == 2) {
			remark = "推荐值发放";
		} else if (moneyType == 3) {
			remark = "参与值发放";
		}
		moneyChangeBean.setRemark(remark);
		moneyChangeBean.setOptId(optId);
		entityPersist.save(moneyChangeBean);
	}

	/**
	 * 计算收益值
	 *
	 * @param rebate
	 * @param rate
	 * @param productCount
	 * @return
	 */
	private Integer getCountRebate(Integer rebate, Float rate, Integer productCount) {
		Float result = rebate * rate * productCount;
		Integer money = 0;
		try {
			money = result.intValue();
		}
		catch (Exception e) {
			logger.error("金额信息转换失败，错误信息：" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return money;
	}
	
	
	
	
	
	/**
	 * 一级 二级 预收益
	 *
	 * @param uid
	 *            用户cid
	 * @param rela
	 *            购买人
	 * @param level
	 *            1-一级，2-二级
	 * @param wxOrder
	 *            微信订单对象
	 * @param directSellingMoney
	 *            变更收益值
	 * @param caseProduct
	 *            产品id
	 * @return boolean 操作是否成功
	 */
	private String saveDirectSelling(String uid, String relaID, String level, String wxOrderID,
			Integer directSellingMoney) {
		CustomerRela rela = entityQueryFactory.createQuery(CustomerRela.class).eq("id", relaID, true).get();
		Order wxOrder = entityQueryFactory.createQuery(Order.class).eq("id", wxOrderID, true).get();
		String result = "false";
		DirectSelling temp = entityQueryFactory.createQuery(DirectSelling.class).eq("uid", uid, true)
				.eq("orderId", wxOrder.getId(), true).get();
		if (null == temp) {
			try {
				DirectSelling directSelling = new DirectSelling();
				directSelling.setUid(uid);
				directSelling.setDownuid(rela.getCid());
				directSelling.setDownlevel(level);
				directSelling.setCid(wxOrder.getProduct_id() + "");
				directSelling.setPid(wxOrder.getProduct_id() + "");
				directSelling.setOrderId(wxOrder.getId());
				directSelling.setCreatetime(wxOrder.getCreat_time());
				int pcie = wxOrder.getOrder_total_price();
				directSelling.setOrdermoney((float) pcie);
				directSelling.setMoney(directSellingMoney.intValue());

				directSelling.setOrderType(Canstants.ORDER_TYPE_FROZEN);// 冻结状态
				entityPersist.save(directSelling);
				result = "true";
				logger.info("保存参与值信息成功，uid:" + uid + ",订单号：" + wxOrder.getId());
			} catch (Exception e) {
				logger.error("保存上级小伙伴的会员收益信息出错");
				e.printStackTrace();
			}
		}
		return JsonUtil.toJson(result);
	}

}
