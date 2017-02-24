package com.threeMMM.model;

import cn.weiykj.core.entity.PkEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by lenovo on 2016/3/16.
 * 平台侧用户表
 */
@Entity
@Table(name = "rru_customer_rela")
public class CustomerRela extends PkEntity {
    private String cid;//customerid
    private String upid; //上三级
    private String upupid; //上二级
    private Integer status;//会员状态
    private Integer rank;
    private Integer profit_dy;
    private Integer profit_vip;
    private Integer profit_frozen;
    private String upupupid; //上三级
    private String appid;
    private String type;//B、商家 S、销售员 T、老师 O或空、其他
    private String city;//所属城市 以下字段皖新业务员专有
    private String company;//分公司
    private String mobile;//手机号
    private Integer companyId;
    private Integer role = 0;//会员角色，默认非管理员
    private String realName;
    private Integer viptype=0;//0 搜索公众号关注，1，扫码关注
    private Date vipdate;//关注公众号时间
    private Integer notPartIn;//不参与排行的小伙伴
    private Date becomeVipdate;//成为会员时间
    @Column
    public Integer getProfit_dy() {
        return profit_dy;
    }

    public void setProfit_dy(Integer profit_dy) {
        this.profit_dy = profit_dy;
    }
    @Column
    public Integer getProfit_vip() {
        return profit_vip;
    }

    public void setProfit_vip(Integer profit_vip) {
        this.profit_vip = profit_vip;
    }
    @Column
    public Integer getProfit_frozen() {
        return profit_frozen;
    }

    public void setProfit_frozen(Integer profit_frozen) {
        this.profit_frozen = profit_frozen;
    }

    @Column
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    @Column
    public String getUpid() {
        return upid;
    }

    public void setUpid(String upid) {
        this.upid = upid;
    }
    @Column
    public String getUpupid() {
        return upupid;
    }

    public void setUpupid(String upupid) {
        this.upupid = upupid;
    }
    @Column
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Column
    public String getUpupupid() {
        return upupupid;
    }

    public void setUpupupid(String upupupid) {
        this.upupupid = upupupid;
    }

    @Column
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Column(name = "type",length = 2)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    @Column
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Column
    public Integer getViptype() {
        return viptype;
    }

    public void setViptype(Integer viptype) {
        this.viptype = viptype;
    }

    @Column
    public Date getVipdate() {
        return vipdate;
    }

    public void setVipdate(Date vipdate) {
        this.vipdate = vipdate;
    }

    @Column
    public Integer getNotPartIn() {
        return notPartIn;
    }

    public void setNotPartIn(Integer notPartIn) {
        this.notPartIn = notPartIn;
    }

    @Column(name = "become_vipdate")
    public Date getBecomeVipdate() {
        return becomeVipdate;
    }

    public void setBecomeVipdate(Date becomeVipdate) {
        this.becomeVipdate = becomeVipdate;
    }
}
