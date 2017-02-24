/**
 * 
 */
package com.threeMMM.service.impl;

import java.util.HashMap;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threeMMM.canstants.SDKcanstants;
import com.threeMMM.commom.CCPRestSDK;
import com.threeMMM.service.ICreateSubAccountService;

/**
 * @author xiaoyong
 */
@Service
public class CreateSubAccountService implements ICreateSubAccountService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateSubAccountService.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.threeMMM.service.ICreateSubAccount#createSubAccount()
	 */
	@Override
	public void createSubAccount(String openID) {
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init(SDKcanstants.API_HTTP, SDKcanstants.API_PORT);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount(SDKcanstants.API_ACCOUNT, SDKcanstants.API_TOKEN);// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId(SDKcanstants.API_APPID);// 初始化应用ID
		result = restAPI.createSubAccount(openID);
		// result =
		// restAPI.createSubAccount("0180e935-2169-45fb-805c-da1d583ede1f");
		LOGGER.info("SDKTestCreateSubAccount result=" + result);

		if ("000000".equals(result.get("statusCode"))) {
			// 正常返回输出data包体信息（map）
			HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for (String key : keySet) {
				Object object = data.get(key);
				System.out.println(key + " = " + object);
			}
		} else {
			// 异常返回输出错误码和错误信息
			LOGGER.error(
					"openID=[" + openID + "]错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
		}

	}

}
