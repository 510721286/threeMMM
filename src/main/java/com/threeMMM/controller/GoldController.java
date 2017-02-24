/**
 * 
 */
package com.threeMMM.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threeMMM.commom.utils.JsonUtil;
import com.threeMMM.service.IGoldService;

/**
 * @author xiaoyong
 */
@Controller
@RequestMapping("/Gold")
public class GoldController {

	@Autowired
	private IGoldService goldService;

	@RequestMapping("/test")
	public void goldtest(String name) {
		goldService.goldtest(name);
	}

	@ResponseBody
	@RequestMapping("/goldTJZByProType")
	public String goldTJZByProType(@RequestBody String json) {
		Map<String, String> map = JsonUtil.toMap(json);
		String name = map.get("name");
		String orderId = map.get("orderId");
		String caseProductId = map.get("caseProductId");
		return goldService.goldTJZByProType(name, orderId, caseProductId, new Date());
	}

	@RequestMapping("/goldCYZByProType")
	public String goldCYZByProType(@RequestBody String json) {
		Map<String, String> map = JsonUtil.toMap(json);
		String name = map.get("name");
		String uid = map.get("uid");
		String relaID = map.get("relaID");
		String level = map.get("level");
		String wxOrderID = map.get("wxOrderID");
		int directSellingMoney = Integer.parseInt(map.get("directSellingMoney"));
		return goldService.goldCYZByProType(name, uid, relaID, level, wxOrderID, directSellingMoney);
	}

	@RequestMapping("/updateTJZByProType")
	public String goldUpdateTJZByProType(@RequestBody String json) {
		Map<String, String> map = JsonUtil.toMap(json);
		String name = map.get("name");
		String orderID = map.get("orderID");
		Integer targetType = Integer.parseInt(map.get("targetType"));
		return goldService.updateTJZByProType(name, orderID, targetType);
	}

	@RequestMapping("/updateCYZByProType")
	public String goldUpdateCYZByProType(@RequestBody String json) {
		Map<String, String> map = JsonUtil.toMap(json);
		String name = map.get("name");
		Integer profitType = Integer.parseInt(map.get("targetOrderType"));
		Long directSellingID = Long.parseLong(map.get("directSellingID"));
		return goldService.updateCYZByProType(name, profitType, directSellingID);
	}
}
