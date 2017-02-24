/**
 * 
 */
package com.threeMMM.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threeMMM.model.MessagesEntity;
import com.threeMMM.service.ICreateSubAccountService;
import com.threeMMM.service.IMessagesService;

/**
 * @author xiaoyong
 */
@Controller
@RequestMapping("/SDK")
public class SDKController {
	@Autowired
	private ICreateSubAccountService createSubAccountService;
	@Autowired
	private IMessagesService messagesService;

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(String openID) {
		createSubAccountService.createSubAccount(openID);
	}

	@ResponseBody
	@RequestMapping(value = "/saveMsg")
	public void saveMsg(MessagesEntity msg) {
		msg.setStatus(0);
		messagesService.save(msg);
	}

	@ResponseBody
	@RequestMapping("/messageHistory")
	public String messageHistory(String fromUserID, String toUserID, Date time) {
		return messagesService.messageHistory(fromUserID, toUserID, time);
	}

	@ResponseBody
	@RequestMapping("/readMessage")
	public void readMessage(String fromUserID, String toUserID) {
		messagesService.readMessage(fromUserID, toUserID);
	}

	@ResponseBody
	@RequestMapping("/messagePage")
	public String messagePage(String fromUserID) {
	return	messagesService.messagePage(fromUserID);
	}

}
