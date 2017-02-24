package com.threeMMM.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yewenzheng on 2016/9/2.
 * 订单记录表
 */
@Entity
@Table(name = "t_mall_order")
public class Order {
    private String id; // '订单号',
    private String buyer_id; // '购买人id',
    private Integer status; // '1-待支付，2-待审核，3-待发货 4已发货 5已完成 6退款中 7已退款 8已取消',
    private Integer order_total_price; // '订单总金额',
    private Integer product_total_price; // '商品的价格',
    private Integer delivery_fee; // '配送费用',
    private Integer draw_total_price; // 总佣金
    private Integer product_id; // '商品id',
    private String product_code; // '商品编码',
    private Integer payment_way; // '1、微信支付；2、支付宝支付；3、银联支付；4、其他支付。',
    private String upid; // '推荐人id',
    private String address_id; // '收货地址id',
    private Integer buy_way; // '购买渠道：1、微信；2、android客户端；3、ios客户端；4，web电脑网页端；5，wap手机网页端；',
    private Date creat_time; // '创建时间',
    private Date update_time; // '最后变更时间',
    private String trans_id; // '交易流水号',
    private String remark; // '备注',
    private String reason; // '取消订单原因',
    private String express_id; // 物流公司
    private String express_code; // 运单编号
    private String express_remark; // 发货备注
    private Integer is_express; // 是否发货

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column
    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }
    @Column
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column
    public Integer getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(Integer order_total_price) {
        this.order_total_price = order_total_price;
    }
    @Column
    public Integer getProduct_total_price() {
        return product_total_price;
    }

    public void setProduct_total_price(Integer product_total_price) {
        this.product_total_price = product_total_price;
    }
    @Column
    public Integer getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(Integer delivery_fee) {
        this.delivery_fee = delivery_fee;
    }
    @Column
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
    @Column
    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }
    @Column
    public Integer getPayment_way() {
        return payment_way;
    }

    public void setPayment_way(Integer payment_way) {
        this.payment_way = payment_way;
    }
    @Column
    public String getUpid() {
        return upid;
    }

    public void setUpid(String upid) {
        this.upid = upid;
    }
    @Column
    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }
    @Column
    public Integer getBuy_way() {
        return buy_way;
    }

    public void setBuy_way(Integer buy_way) {
        this.buy_way = buy_way;
    }
    @Column
    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }
    @Column
    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    @Column
    public String getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }
    @Column
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    @Column
    public String getExpress_id() {
        return express_id;
    }

    public void setExpress_id(String express_id) {
        this.express_id = express_id;
    }
    @Column
    public String getExpress_code() {
        return express_code;
    }

    public void setExpress_code(String express_code) {
        this.express_code = express_code;
    }
    @Column
    public String getExpress_remark() {
        return express_remark;
    }

    public void setExpress_remark(String express_remark) {
        this.express_remark = express_remark;
    }
    @Column
    public Integer getIs_express() {
        return is_express;
    }

    public void setIs_express(Integer is_express) {
        this.is_express = is_express;
    }

    public Integer getDraw_total_price() {
        return draw_total_price;
    }

    public void setDraw_total_price(Integer draw_total_price) {
        this.draw_total_price = draw_total_price;
    }
}

