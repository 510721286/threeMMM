package com.threeMMM.model;

import javax.persistence.*;

import java.util.Date;

/**
 * Created by liu on 16/1/25.
 */
@Entity
@Table(name = "wx_order")
public class WxOrder {

	private Long id;

	private String order_id;

	private Integer order_status;

	private Float order_total_price;

	private Long order_create_time;

	private Date orderCreateTime;

	private Float order_express_price;

	private String buyer_openid;

	private String receiver_name;

	private String receiver_province;

	private String receiver_city;

	private String receiver_address;

	private String receiver_mobile;

	private String product_id;

	private String product_name;

	private Float product_price;

	private String product_sku;

	private Integer product_count;

	private String product_img;

	private String delivery_id;

	private String delivery_company;

	private String trans_id;

	private String receiver_zone;

	private String receiver_zip;

	private String buyer_nick;

	private Integer rp_status;

	private String productPrice;

	private String orderTotalPrice;

	private Long caseId;

	private Date updateTime;

	private Date deliveryTime;// 出库时间

	private Date createTime;// 订单入库时间

	private Integer product_type;// 商品类型,1-实物,2-虚拟商品

	public Integer getProduct_type() {
		return product_type;
	}

	public void setProduct_type(Integer productType) {
		product_type = productType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public Integer getRp_status() {
		return rp_status;
	}

	public void setRp_status(Integer rp_status) {
		this.rp_status = rp_status;
	}

	@Column
	public String getBuyer_nick() {
		return buyer_nick;
	}

	public void setBuyer_nick(String buyer_nick) {
		this.buyer_nick = buyer_nick;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/* 推荐人的openID */
	private String upOpenid;

	@Column
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Column
	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	@Column
	public Float getOrder_total_price() {
		return order_total_price;
	}

	public void setOrder_total_price(Float order_total_price) {
		this.order_total_price = order_total_price;
	}

	public Long getOrder_create_time() {
		return order_create_time;
	}

	public void setOrder_create_time(Long order_create_time) {
		this.order_create_time = order_create_time;
	}

	@Column
	public Float getOrder_express_price() {
		return order_express_price;
	}

	public void setOrder_express_price(Float order_express_price) {
		this.order_express_price = order_express_price;
	}

	@Column
	public String getBuyer_openid() {
		return buyer_openid;
	}

	public void setBuyer_openid(String buyer_openid) {
		this.buyer_openid = buyer_openid;
	}

	@Column
	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	@Column
	public String getReceiver_province() {
		return receiver_province;
	}

	public void setReceiver_province(String receiver_province) {
		this.receiver_province = receiver_province;
	}

	@Column
	public String getReceiver_city() {
		return receiver_city;
	}

	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}

	@Column
	public String getReceiver_address() {
		return receiver_address;
	}

	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}

	@Column
	public String getReceiver_mobile() {
		return receiver_mobile;
	}

	public void setReceiver_mobile(String receiver_mobile) {
		this.receiver_mobile = receiver_mobile;
	}

	@Column
	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	@Column
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	@Column
	public Float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Float product_price) {
		this.product_price = product_price;
	}

	@Column
	public String getProduct_sku() {
		return product_sku;
	}

	public void setProduct_sku(String product_sku) {
		this.product_sku = product_sku;
	}

	@Column
	public Integer getProduct_count() {
		return product_count;
	}

	public void setProduct_count(Integer product_count) {
		this.product_count = product_count;
	}

	@Column
	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	@Column
	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	@Column
	public String getDelivery_id() {
		return delivery_id;

	}

	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}

	@Column
	public String getDelivery_company() {
		return delivery_company;
	}

	public void setDelivery_company(String delivery_company) {
		this.delivery_company = delivery_company;
	}

	@Column
	public String getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}

	@Column
	public String getReceiver_zone() {
		return receiver_zone;
	}

	public void setReceiver_zone(String receiver_zone) {
		this.receiver_zone = receiver_zone;
	}

	@Column
	public String getReceiver_zip() {
		return receiver_zip;
	}

	public void setReceiver_zip(String receiver_zip) {
		this.receiver_zip = receiver_zip;
	}

	@Column
	public String getUpOpenid() {
		return upOpenid;
	}

	public void setUpOpenid(String upOpenid) {
		this.upOpenid = upOpenid;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(String orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	@Column(name = "update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "delivery_time")
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Override
	public String toString() {
		return "WxOrder{" + "id=" + id + ", order_id='" + order_id + '\'' + ", order_status=" + order_status + ", order_total_price="
		        + order_total_price + ", order_create_time=" + order_create_time + ", orderCreateTime=" + orderCreateTime + ", order_express_price="
		        + order_express_price + ", buyer_openid='" + buyer_openid + '\'' + ", receiver_name='" + receiver_name + '\''
		        + ", receiver_province='" + receiver_province + '\'' + ", receiver_city='" + receiver_city + '\'' + ", receiver_address='"
		        + receiver_address + '\'' + ", receiver_mobile='" + receiver_mobile + '\'' + ", product_id='" + product_id + '\''
		        + ", product_name='" + product_name + '\'' + ", product_price=" + product_price + ", product_sku='" + product_sku + '\''
		        + ", product_count=" + product_count + ", product_img='" + product_img + '\'' + ", delivery_id='" + delivery_id + '\''
		        + ", delivery_company='" + delivery_company + '\'' + ", trans_id='" + trans_id + '\'' + ", receiver_zone='" + receiver_zone + '\''
		        + ", receiver_zip='" + receiver_zip + '\'' + ", buyer_nick='" + buyer_nick + '\'' + ", rp_status=" + rp_status + ", productPrice='"
		        + productPrice + '\'' + ", orderTotalPrice='" + orderTotalPrice + '\'' + ", caseId=" + caseId + ", upOpenid='" + upOpenid + '\''
		        + '}';
	}

	@Column(length = 8)
	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
}
