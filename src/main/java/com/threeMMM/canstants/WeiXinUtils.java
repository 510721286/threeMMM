package com.threeMMM.canstants;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import cn.weiykj.util.HttpClientUtils;
import cn.weiykj.util.RedisUtils;
import cn.weiykj.weixin.pojo.JsApiPojo;
import cn.weiykj.weixin.pojo.TokenPojo;
import cn.weiykj.weixin.pojo.WeiXinQrcodePojo;

public class WeiXinUtils {
	public static Logger logger = Logger.getLogger(WeiXinUtils.class);
    public static String APP_ID;
    public static String APP_SECRET;
    public static String ACCESS_TOKEN;
    public static String JS_API_TOKEN;
    public static String CARD_API_TOKEN;
    public static final String WEIXIN_URL = "https://api.weixin.qq.com/cgi-bin/";
    public static String WX_AT_URL;
    public static String WX_QRCODE_CREATE_URL;
    public static String WX_QRCODE_GET_URL;
    public static String WX_BASEINFO_URL;
    public static String WX_ALLINFO_URL;
    public static String DOMAIN="http://b.jszhaomi.cn";

    public WeiXinUtils() {
    }

    public static WeiXinQrcodePojo createQrcode(String sceneId, Boolean isTmp) {
        String ret = null;
        if(isTmp.booleanValue()) {
            ret = HttpClientUtils.doPost(WX_QRCODE_CREATE_URL + ACCESS_TOKEN, "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": \""+sceneId+"\"}}}", "utf-8", false);
        } else {
            ret = HttpClientUtils.doPost(WX_QRCODE_CREATE_URL + ACCESS_TOKEN, "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"" + sceneId + "\"}}}", "utf-8", false);
        }

        return (WeiXinQrcodePojo)JSON.parseObject(ret, WeiXinQrcodePojo.class);
    }

    static {
        InputStream is = null;
        InputStream isCustom = WeiXinUtils.class.getResourceAsStream("/properties/weixin.properties");
        is = isCustom == null?WeiXinUtils.class.getResourceAsStream("/properties/base.weixin.properties"):isCustom;
        Properties p = new Properties();

        try {
            p.load(is);
            APP_ID = p.getProperty("AppID");
            APP_SECRET = p.getProperty("AppSecret");
            WX_AT_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APP_ID + "&secret=" + APP_SECRET + "&grant_type=authorization_code&code=";
            WX_BASEINFO_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APP_ID + "&response_type=code&scope=snsapi_base&state=";
            WX_ALLINFO_URL = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN&access_token=";
            WX_QRCODE_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
            WX_QRCODE_GET_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

            ACCESS_TOKEN = RedisUtils.get("ACCESS_TOKEN");
            JS_API_TOKEN = RedisUtils.get("JS_API_TOKEN");
            try{
                if(StringUtils.isEmpty(ACCESS_TOKEN)||StringUtils.isEmpty(JS_API_TOKEN)){
                    TokenPojo e = (TokenPojo) JSON.parseObject(HttpClientUtils.doGetForSSL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRET, "utf-8"), TokenPojo.class);
                    ACCESS_TOKEN = e.getAccess_token();
                    Integer ACCESS_TOKEN_EXPIRES = e.getExpires_in();
                    JsApiPojo jap = (JsApiPojo) JSON.parseObject(HttpClientUtils.doGetForSSL("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + ACCESS_TOKEN + "&type=jsapi", "utf-8"), JsApiPojo.class);
                    JS_API_TOKEN = jap.getTicket();
                    Integer JS_API_TICKET_EXPIRES = jap.getExpires_in();
                    RedisUtils.set("ACCESS_TOKEN",ACCESS_TOKEN_EXPIRES,ACCESS_TOKEN);
                    RedisUtils.set("JS_API_TOKEN", JS_API_TICKET_EXPIRES,JS_API_TOKEN);
                    System.out.println(ACCESS_TOKEN+"<---->"+JS_API_TOKEN);
                }
            }catch (Exception e){

            }
        } catch (Exception var6) {
            var6.printStackTrace();
            System.out.println("------------------Error Message from WeiXinUtil:"+var6.getMessage()+"------------------------");
        }

    }
    
	/**
	 * 获取用户信息
	 * 
	 * @param openid
	 * @return
	 */
	public static String getUserInfo(String openid) {
		
		String userInfo = null;
		try {
			String BASEINFOURL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + WeiXinUtils.ACCESS_TOKEN + "&openid=" + openid
			        + "&lang=zh_CN";
			 userInfo = HttpClientUtils.doGetForSSL(BASEINFOURL, "utf-8");
			logger.info("从微信接口获取用户(openid=" + openid + ")信息：" + userInfo);
		}
		catch (Exception e) {
			logger.error("从微信接口获取用户信息失败，openid:" + openid  + e.getStackTrace());
			e.printStackTrace();
		}
		return userInfo;
	}

}