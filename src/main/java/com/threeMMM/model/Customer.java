package com.threeMMM.model;

import cn.weiykj.core.entity.PkEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by huwei1 on 15/4/27.
 */
@Entity
@Table(name = "rru_customer")
public class Customer extends PkEntity {
    private String openId;
    private String unionId;
    private String upCustomId;//被传播的用户openID
    private String area;//地区
    private String userName;//姓名
    private Integer userType;//用户类型：1：高价值高转换用户 2：经纪人 3：自媒体多粉丝用户
    private String mobile;
    private Integer totalPoint;//剩余积分
    private Integer totalJoin;//总参与数
    private Integer allPoint;//总积分数＝剩余积分＋已兑换积分。
    private String nickName;
    private String appid;

    @Column(name = "openid")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Column(name = "unionid")
    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Column(name = "upopenid")
    public String getUpCustomId() {
        return upCustomId;
    }

    public void setUpCustomId(String upCustomId) {
        this.upCustomId = upCustomId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "uname")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "usertype")
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "totalpoint")
    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    @Column(name = "totaljoin")
    public Integer getTotalJoin() {
        return totalJoin;
    }

    public void setTotalJoin(Integer totalJoin) {
        this.totalJoin = totalJoin;
    }

    @Column(name = "allpoint")
    public Integer getAllPoint() {
        return allPoint;
    }

    public void setAllPoint(Integer allPoint) {
        this.allPoint = allPoint;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Column
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
