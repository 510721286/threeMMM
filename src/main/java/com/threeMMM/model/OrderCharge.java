package com.threeMMM.model;

import cn.weiykj.core.entity.AutoPkEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liu on 16/2/2.
 */
@Entity
@Table(name = "rru_order")
public class OrderCharge{
    private Long id;
    private String orderNo;
    private Date orderTime;
    private float payNum;
    private Integer status;
    private String muid;
    private Integer orderType;
    private Long caseId;
    private String description;

    private Date updateTime;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    @Column
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Column
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Column
    public float getPayNum() {
        return payNum;
    }

    public void setPayNum(float payNum) {
        this.payNum = payNum;
    }

    @Column
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column
    public String getMuid() {
        return muid;
    }

    public void setMuid(String muid) {
        this.muid = muid;
    }

    @Column
    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderCharge{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", orderTime=" + orderTime +
                ", payNum=" + payNum +
                ", status=" + status +
                ", muid='" + muid + '\'' +
                ", orderType=" + orderType +
                ", caseId=" + caseId +
                ", description='" + description + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}

