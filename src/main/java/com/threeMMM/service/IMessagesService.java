/**
 * 
 */
package com.threeMMM.service;

import java.util.Date;

import com.threeMMM.model.MessagesEntity;

/**
 * @author xiaoyong
 */
public interface IMessagesService {
	/**
	 * 保存聊天内容
	 * 
	 * @param msg
	 */
	public void save(MessagesEntity msg);

	/**
	 * 返回历史消息明细
	 * 
	 * @param fromUserID
	 * @param toUserID
	 * @return
	 */
	public String messageHistory(String fromUserID, String toUserID, Date time);

	/**
	 * 消息修改成已读
	 * 
	 * @param fromUserID
	 * @param toUserID
	 */
	public void readMessage(String fromUserID, String toUserID);
	
	
	
	public String messagePage(String fromUserID);
}
