package com.threeMMM.model;

/**
 * Created by ysen6 on 2016/9/1.
 */

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name="t_mall_product" )
public class Commodity {
    private Integer id;   //idp_status
    private String title;   //标题
    private String productName;//商品名称
    private String productCode;//商品编码 自动生成的英文+数字
    private String tag;  //标签
    private Integer sort;  //排序
    private String describe;  //描述
    private String bigPic;  //封面 封面首页展示
    private String smallPic;  //小图 小图(订单页面的图等)
    private String smallPic2;  //分享的缩略图
    private String detail;  //商品详情
    private Integer productStatus;  //状态 0:删除 1:上架 2:下架
    private Integer areaId;   //产地id 关联地区表
    private Integer expenses;   //运费 0:商家承担 1:用户承担
    private Integer expensesTemp; //运费模板 用户承担付邮才有运费模板
    private Integer sellerId;   //商家id 这个商品属于哪个商家的
    private Integer categoryId; //商品分类 属于生鲜还是服饰
    private Integer invented;  //虚拟商品 1是 0 否 （预留）
    private Date updateTime; //修改时间
    private Date rdate;  //上架时间
    private Date ddate;  //下架时间
    private Integer areaLevel ; //地区层级
    private Integer countryId; //省份ID
    private Integer provinceId; //省份ID
    private Integer cityIdld;  //城市ID
    private Integer minPrice;  //最低价格
    private Integer maxPrice;  //最高价格
    private Integer maxOriginalPrice; //最高原价
    private Integer minOriginalPrice; //最低原价
    private Integer readCount; //阅读量
    private Integer shareCount; //分享量
    private String backGroundColor;  //背景色
    private String titleColor;    //标题色
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "p_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    @Column(name = "p_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @Column(name = "pdescribe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    @Column(name = "big_pic")
    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }
    @Column(name = "small_pic")
    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    @Column(name = "p_status")
    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }
    @Column(name = "area_id")
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
    @Column(name = "area_level")
    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    @Column(name = "expenses")
    public Integer getExpenses() {
        return expenses;
    }

    public void setExpenses(Integer expenses) {
        this.expenses = expenses;
    }
    @Column(name = "expenses_temp")
    public Integer getExpensesTemp() {
        return expensesTemp;
    }

    public void setExpensesTemp(Integer expensesTemp) {
        this.expensesTemp = expensesTemp;
    }
    @Column(name = "seller_id")
    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Column(name = "category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    @Column(name = "invented")
    public Integer getInvented() {
        return invented;
    }

    public void setInvented(Integer invented) {
        this.invented = invented;
    }
    @Column(name = "upd_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @Column(name = "small_pic2")
    public String getSmallPic2() {
        return smallPic2;
    }

    public void setSmallPic2(String smallPic2) {
        this.smallPic2 = smallPic2;
    }
    @Column(name = "rdate")
    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }
    @Column(name = "ddate")
    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }
    @Column(name = "min_price")
    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }
    @Column(name="max_price")
    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
    @Column(name="max_original_price")
    public Integer getMaxOriginalPrice() {
        return maxOriginalPrice;
    }

    public void setMaxOriginalPrice(Integer maxOriginalPrice) {
        this.maxOriginalPrice = maxOriginalPrice;
    }
    @Column(name="min_original_price")
    public Integer getMinOriginalPrice() {
        return minOriginalPrice;
    }

    public void setMinOriginalPrice(Integer minOriginalPrice) {
        this.minOriginalPrice = minOriginalPrice;
    }
    @Column(name="read_count")
    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
    @Column(name="share_count")
    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }
    @Column(name="background_color")
    public String getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(String backGroundColor) {
        this.backGroundColor = backGroundColor;
    }
    @Column(name="title_color")
    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    @Transient
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
    @Transient
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    @Transient
    public Integer getCityIdld() {
        return cityIdld;
    }

    public void setCityIdld(Integer cityIdld) {
        this.cityIdld = cityIdld;
    }
}
