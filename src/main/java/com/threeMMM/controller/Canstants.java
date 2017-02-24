/**
 * 
 */
package com.threeMMM.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyong
 */
public interface Canstants {

	// DB TYPE
	public final static String DB_TYPE_JIANGHAO = "JIANGHAO";
	public final static String DB_TYPE_YUEJIA = "YUEJIA";
	
	
	 /*代言佣金比例常量*/
    public static Double DY_RATE = 0.60;

    public final static Integer POINT_TYPE_SCAN = 1;//扫码
    public final static Integer POINT_TYPE_JOIN = 2;//报名
    public final static Integer POINT_TYPE_SHARE = 3;//分享
    public final static Integer POINT_TYPE_CHANGE = 4;//兑换
    public final static Integer POINT_TYPE_CONFIRM = 5;//奖励

    /*大厅文章类别**/
    public final static String CASE_TYPE_TASK="002";//任务
    public final static String CASE_TYPE_FIND="010";//发现
    public final static String CASE_TYPE_ACTIVE="011";//活动

    /*操作响应状态码*/
    public final static Integer SUCCESS = 1;//
    public final static Integer FAILED = 2;//
    public final static Integer THROWS_EXCEPTION = 3;//
    public final static Integer TRUE = 1;//
    public final static Integer FALSE = 0;//
    /*新增或修改操作响应状态码*/
    public final static Integer INVALID_CHARS = -1;//包含非法字符
    public final static Integer INVALID_MAXLEGTH = 0;//超出最大长度限制
    public final static Integer INVALID_MINLEGTH = -2;//小于最小长度

    /*个人中心相关状态码*/
    public final static Integer CASE_FAVOURITE=1;//已收藏
    public final static Integer CANCEL_FAVOURITE=0;//取消收藏

    /*CasePersonal状态*/
    public final static Integer STATUS_OK=1;
    public final static Integer STATUS_REVIEWING=2;
    public final static Integer STATUS_PUBLISH=3;
    public final static Integer STATUS_NOPASS=4;
    public final static Integer STATUS_DEL=5;

    public final static Integer ISDELETE_Y=1;
    public final static Integer ISDELETE_N=0;

    /*公司信息*/
    public final static Integer COMPANY_TYPE_MENDIAN = 1;
    public final static Integer COMPANY_TYPE_COMP = 2;

    /*事件处理*/
    public final static String WEIXIN_EVENT_MERCHANT_ORDER = "merchant_order";
    public final static String WEIXIN_EVENT_LOCATION = "LOCATION";


    /*消息状态*/
    public final static String MESSAGE_STATUS_OK = "OK";
    public final static String MESSAGE_STATUS_INIT = "INIT";
    public final static String MESSAGE_STATUS_MERCHANT_NOT = "NOT PLATFORM PRODUCT";
    public final static String MESSAGE_STATUS_WXORDER_FAIL = "WXORDER_FAIL";

    /*会员等级*/
    public final static String VIP_STATUS_LEVEL_ONE = "1";
    public final static String VIP_STATUS_LEVEL_TWO = "2";

    /*公司组织架构常量值*/
    public final static char IS_LEAF = 'Y';
    public final static char IS_NOT_LEAF = 'N';
    public final static Integer LEVEL_ONE = 1;
    public final static Integer LEVEL_TWO = 2;
    public final static Integer LEVEL_THREE = 3;
    public final static Integer LEVEL_FOUR = 4;
    public final static Integer GROUP_TYPE_COMP = 1;//集团总部和专业公司
    public final static Integer GROUP_TYPE_SUBCOM = 2;//市县公司

    /**/
    public final static Integer QRCODE_SENCE_TYPE_EMPLOYEE = 4;
    public final static Integer QRCODE_SENCE_TYPE_SHOP = 5;
    //虚拟账号的状态
    public final static Integer VIRTUAL_ACCOUNT_NOT_SALE = 1;//未出售
    public final static Integer VIRTUAL_ACCOUNT_ALREADY_SOLD  = 2;//已出售

    /*龙虎榜数据剔除可以作弊人员*/
    public final static Integer RELA_NOT_PART_IN_TG = 1;//不参与推广人排名
    public final static Integer RELA_NOT_PART_IN_YQ = 2;//不参与邀请人排名
    public final static Integer RELA_NOT_PART_IN_DY = 3;//不参与代言人排名
    public final static Integer RELA_NOT_PART_IN_TGYQ = 12;//不参与推广、邀请人排名
    public final static Integer RELA_NOT_PART_IN_TGDY = 13;//不参与推广、代言排名
    public final static Integer RELA_NOT_PART_IN_YQDY = 23;//不参与代言、邀请人排名
    public final static Integer RELA_NOT_PART_IN_TGYQDY = 123;//不参与龙虎榜排名

    //case_product 中商品的类型
    public final static Integer CASE_PRODUCT_BOOK =1 ;//书本
    public final static Integer CASE_PRODUCT_VIRTUAL_ACCOUNT =2 ;//虚拟账号

    //入账订单类型
    public final static Integer ORDERTYPE_OF_ORDERCHARGE = 3;//微信小店订单支付
    public final static Integer ORDERTYPE_OF_DY_ORDERCHARGE = 301;//代言订单

    //订单状态
    public final static Integer ORDER_STATUS_WAITPAY = 1;//待支付
    public final static Integer ORDER_STATUS_TOBESHIPPED = 2;//待审核
    public final static Integer ORDER_STATUS_DELIVERY = 3;//待发货
    public final static Integer ORDER_STATUS_CANCEL = 8;//订单已被取消
    public final static Integer ORDER_STATUS_SHIPPED = 4;//已发货
    public final static Integer ORDER_STATUS_FINISHED = 5;//已完成
    public final static Integer ORDER_STATUS_QUEST = 8;//维权
    public final static Integer ORDER_STATUS_REFUND = 30;//用户已退款public final static Integer ORDER_STATUS_TOBESHIPPED = 2;//待发货
    public final static String ORDER_STATUS_DELIVERY_MESSAGE = "商品已出库，暂不可申请退货";//已出库
    public final static String ORDER_STATUS_CANCEL_MESSAGE = "订单已取消";//订单已被取消
    public final static String ORDER_STATUS_SHIPPED_MESSAGE = "商品已发货，请联系物流";//已发货
    public final static String ORDER_STATUS_FINISHED_MESSAGE = "交易成功";//已完成
    public final static String ORDER_STATUS_QUEST_MESSAGE = "维权中";//维权
    public final static String ORDER_STATUS_REFUND_MESSAGE = "已退款";//用户已退款
    public final static String ORDER_STATUS_CONFIRMRECEIPT_MESSAGE = "确认收货？";//用户用户点击确认收货
    public final static String ORDER_STATUS_CONFIRMRECEIPT_NOTSEND_MESSAGE = "该订单尚未发货，您确认收货？";//未发货就确认收货

    //资金状态，推荐值与参与值
    public final static Integer ORDER_TYPE_OK = 301;//正常完成状态
    public final static Integer ORDER_TYPE_FROZEN = 302;//冻结：已发货但未确认收货
    public final static Integer ORDER_TYPE_CANCEL = 303;//取消：购买者手动取消订单
    public final static Integer ORDER_TYPE_REFUND = 304;//退款：购买者手动取消订单并正确退款
    public final static Integer  ORDER_TYPE_CONFIRM = 305;//确认收货：购买者手动确认收货

    public final static Integer ORDER_TYPE_PROFIT_SEND = 1;//收益值发放
    public final static Integer ORDER_TYPE_PROFIT_REFUND = 2;//收益值退回

    public final static Integer CASE_RECOMMEND_STATUS_OK = 1;
    public final static Integer CASE_RECOMMEND_STATUS_INVALID = 2;

    public final static String ERRORCODE_INVALID_ACCESSTOKEN = "40001";

    public final static String SUBSCRIBE_MESSAGE = "Hi，我的朋友！\n" +
            "欢迎关注匠好。匠好知道您热爱生活、追求品质，我们为您甄选了优质的商品，它们有逼格更具内涵。\n" +
            "您收获的不只是好商品，还有乐趣与喜悦。<a href='http://b.jszhaomi.cn/service/task'>快去体验吧！</a>";
    
    //字母和数字组合
    public static String CHARACTER_AND_DIGITAL= "^[A-Za-z0-9]+$";
    
    public static Map<String,String> deliveryMap = new HashMap<String,String>();
    public static Map<String,String> deliveryMap2 = new HashMap<String,String>();

    public static final String ZJS = deliveryMap.put("ZJS", "宅急送	");
    
    /**
     * 连续签到7天
     */
    public static  int SING_CONTINUITY = 7;
    /**
     * 签到固定收益
     */
    public static  int SING_GOLD = 5;
}
