package com.threeMMM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by liu on 16/1/25.
 */
@Entity
@Table(name = "case_product")
public class CaseProduct {
    private Long id;
    private Long caseId;//文章ID
    private String product_id;//商品编号
    private Float dyRate;//代言比例
    private Float dsRate1;//直销一级分成比例
    private Float dsRate2;//直销二级分成比例
    private Integer rebate;//佣金
    private Integer price;//商品价格，默认为最低价
    private Integer product_type ;//商品类型 1、实物商品 2、虚拟商品
    private String product_name;//商品名称
    private String product_sku;//库存量单位
    private Integer  minPrice;//最低价
    private Integer maxPrice;//最高价
    private Integer orgPrice;//商品价格原价
    private Integer orgMinPrice;//原最低价
    private Integer orgMaxPrice;//原最高价


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
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @Column(name = "dy_rate")
    public Float getDyRate() {
        return dyRate;
    }

    public void setDyRate(Float dyRate) {
        this.dyRate = dyRate;
    }

    @Column(name = "ds_rate1")
    public Float getDsRate1() {
        return dsRate1;
    }

    public void setDsRate1(Float dsRate1) {
        this.dsRate1 = dsRate1;
    }

    @Column(name = "ds_rate2")
    public Float getDsRate2() {
        return dsRate2;
    }

    public void setDsRate2(Float dsRate2) {
        this.dsRate2 = dsRate2;
    }

    @Column
    public Integer getRebate() {
        return rebate;
    }

    public void setRebate(Integer rebate) {
        this.rebate = rebate;
    }

    @Column
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column
    public Integer getProduct_type() {
        return product_type;
    }

    public void setProduct_type(Integer product_type) {
        this.product_type = product_type;
    }

    @Column
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Column(name = "product_sku")
    public String getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(String product_sku) {
        this.product_sku = product_sku;
    }

    @Column(name = "min_price")
    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    @Column(name = "max_price")
    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Column(name = "org_price")
    public Integer getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(Integer orgPrice) {
        this.orgPrice = orgPrice;
    }

    @Column(name = "org_min_price")
    public Integer getOrgMinPrice() {
        return orgMinPrice;
    }

    public void setOrgMinPrice(Integer orgMinPrice) {
        this.orgMinPrice = orgMinPrice;
    }

    @Column(name = "org_max_price")
    public Integer getOrgMaxPrice() {
        return orgMaxPrice;
    }

    public void setOrgMaxPrice(Integer orgMaxPrice) {
        this.orgMaxPrice = orgMaxPrice;
    }
}
