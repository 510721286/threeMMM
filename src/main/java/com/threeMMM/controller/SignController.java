/**
 * 
 */
package com.threeMMM.controller;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.threeMMM.core.Dao.IEntityPersist;
import com.threeMMM.core.Dao.IEntityQueryFactory;
import com.threeMMM.model.SignEntry;
import com.threeMMM.util.DateTimeUtil;

/**
 * @author xiaoyong
 */
@Controller
public class SignController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignController.class);
	@Autowired
	protected IEntityQueryFactory entityQueryFactory;

	@Autowired
	protected IEntityPersist entityPersist;
	
	@RequestMapping(value = "/insert")
	public void insert(String openID) {
		// 查询昨天的签到记录
		Date[] date = DateTimeUtil.getTodayAndTomorrow(1);
		SignEntry signEntry =entityQueryFactory.createQuery(SignEntry.class).between("signDate", date[0], date[1]).eq("openid", openID, true).get();
		if(null!=signEntry){
			LOGGER.info("今天已经签过了");
			return;
		}
		date = DateTimeUtil.getTodayAndYesterday(1);
		signEntry =entityQueryFactory.createQuery(SignEntry.class).between("signDate", date[0], date[1]).eq("openid", openID, true).get();
		
		if (null == signEntry) {
			signEntry = new SignEntry();
			signEntry.setOpenid(openID);
			signEntry.setSignBenefit(Canstants.SING_GOLD);
			signEntry.setSignDay(1);
			//signEntry.setGoldTotal(Canstants.SING_GOLD);
			entityPersist.save(signEntry);
		} else {
			// 查出最近的一条签到记录
			//signEntry =entityQueryFactory.createQuery(SignEntry.class).desc("id", true).eq("openid", openID, true).get();
			SignEntry	signEntryInfo  = new SignEntry();
			int num = randomNum(signEntry.getSignDay());
			signEntryInfo.setOpenid(openID);
			signEntryInfo.setSignBenefit(num);
			signEntryInfo.setSignDay(signEntry.getSignDay() + 1);
			entityPersist.save(signEntryInfo);
		}
	}

	private int randomNum(int num) {
		// 连续签到时间大于等于7天
		if (num % Canstants.SING_CONTINUITY == 0) {
			int signGold = new Random().nextInt(50);
			int randomNum = (int) (Math.random() * 100) + 1;
			randomNum=100;
			if (randomNum < 96) {
				return signGold + Canstants.SING_GOLD;
			} else {
				return signGold + 50 + Canstants.SING_GOLD;
			}

		} else {
			return Canstants.SING_GOLD;
		}

	}
}
