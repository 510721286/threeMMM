package com.threeMMM.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liushengli on 2016/8/1.
 * 账户流水记录
 */
@Entity
@Table(name = "money_change")
public class MoneyChange {
    private Long id;
    private String openid;
    private Date optTime;//操作时间
    private Integer changType;//变动类型，1支出，2收入
    private Integer moneyType;//变动渠道，1提现，2推荐值，3参与值
    private Integer balance;//操作后的账户余额
    private Integer changeMoney;//变动金额
    private String appid;
    private String remark;//备注
    private String optId;//操作编号，该编号使用变动渠道对应记录的ID

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Column(name = "opt_time")
    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    @Column(name = "change_type")
    public Integer getChangType() {
        return changType;
    }

    public void setChangType(Integer changType) {
        this.changType = changType;
    }

    @Column(name = "money_type")
    public Integer getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Integer moneyType) {
        this.moneyType = moneyType;
    }

    @Column(name = "balance")
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Column(name = "change_money")
    public Integer getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(Integer changeMoney) {
        this.changeMoney = changeMoney;
    }

    @Column
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Column
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "opt_id")
    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

}
