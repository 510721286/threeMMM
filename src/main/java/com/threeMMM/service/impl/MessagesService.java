/**
 * 
 */
package com.threeMMM.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeMMM.canstants.ChatCanstants;
import com.threeMMM.commom.utils.JsonUtil;
import com.threeMMM.core.Dao.IEntityPersist;
import com.threeMMM.core.Dao.IEntityQueryFactory;
import com.threeMMM.model.MessagesEntity;
import com.threeMMM.service.IMessagesService;

/**
 * @author xiaoyong
 */
@Service
public class MessagesService implements IMessagesService {

	@Autowired
	protected IEntityQueryFactory entityQueryFactory;

	@Autowired
	protected IEntityPersist entityPersist;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.threeMMM.service.IMessagesService#save(antlr.debug.MessageEvent)
	 */
	@Override
	public void save(MessagesEntity msg) {
		entityPersist.save(msg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.threeMMM.service.IMessagesService#messageDetail(com.threeMMM.model.
	 * MessagesEntity)
	 *
	 */
	/**
	 * 
	 * @param fromUserID
	 * @param toUserID
	 * @param countNum
	 *            查询条数 页面现有条数+默认条数
	 * @return
	 */
	@Override
	public String messageHistory(String fromUserID, String toUserID, Date time) {
		List<MessagesEntity> list = entityQueryFactory.createQuery(MessagesEntity.class).desc("creattime", true)
				.in("touserid", true, toUserID, fromUserID).in("fromuserid", true, fromUserID, toUserID)
				.le("creattime", time, false).list(ChatCanstants.COUNTRESULT);
		return validate(list);
	}

	/**
	 * 未读消息变已读
	 */
	@Override
	public void readMessage(String fromUserID, String toUserID) {
		List<MessagesEntity> list = entityQueryFactory.createQuery(MessagesEntity.class).eq("touserid", toUserID, false)
				.eq("fromuserid", fromUserID, false).eq("status", 0, false).list();
		for (MessagesEntity messageInfo : list) {
			messageInfo.setType(1);
			entityPersist.update(messageInfo);
		}
	}

	/**
	 * 消息列表页面
	 */
	@Override
	public String messagePage(String fromUserID) {
		String sql = "select *  from rru_messages where id in (select max(id) from rru_messages r where r.fromuserid =? or r.touserid=? group by r.fromuserid,r.touserid)";
		String[] sqlParameter = new String[] { fromUserID, fromUserID };
		//List<Map<String, Object>> list = entityQueryFactory.createQuery(Map.class).querySQLforMap(sql, sqlParameter);
		List<MessagesEntity> list = entityQueryFactory.createQuery(MessagesEntity.class).querySQL(sql, sqlParameter);
		return validate(list);
		//return "";
	}

	/**
	 * 校验
	 * 
	 * @param list
	 * @return
	 */
	private String validate(List<MessagesEntity> list) {
		if (null == list || list.isEmpty()) {
			return ChatCanstants.ERROR;
		}
		String datas = JsonUtil.toJson(list);
		return datas;
	}
}
