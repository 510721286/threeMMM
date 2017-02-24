package com.threeMMM.model;

import cn.weiykj.core.entity.AutoPkEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lenovo on 2016/3/11.
 */
@Entity
@Table(name = "rru_direct_selling")
public class DirectSelling {
    private Long id;
    private String orderId;
    private String cid; //caseid
    private String pid;
    private String uid; //customerid
    private String downuid; //下线customerid
    private String downlevel; //下线级别
    private Integer money;
    private Float ordermoney;
    private Date createtime;
    private Date updateTime;//最后操作时间
    private Integer orderType;//301-正常结束，302-冻结，303-取消

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    @Column
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    @Column
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    @Column
    public String getDownuid() {
        return downuid;
    }

    public void setDownuid(String downuid) {
        this.downuid = downuid;
    }
    @Column
    public String getDownlevel() {
        return downlevel;
    }

    public void setDownlevel(String downlevel) {
        this.downlevel = downlevel;
    }
    @Column
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
    @Column
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Column
    public Float getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(Float ordermoney) {
        this.ordermoney = ordermoney;
    }

    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "order_type",length = 2)
    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "DirectSelling{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", cid='" + cid + '\'' +
                ", pid='" + pid + '\'' +
                ", uid='" + uid + '\'' +
                ", downuid='" + downuid + '\'' +
                ", downlevel='" + downlevel + '\'' +
                ", money=" + money +
                ", ordermoney=" + ordermoney +
                ", createtime=" + createtime +
                ", updateTime=" + updateTime +
                ", orderType=" + orderType +
                '}';
    }
}
