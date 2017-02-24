/**
 * 
 */
package com.threeMMM.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xiaoyong
 */
@Entity
@Table(name = "t_check_in")
public class SignEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9085307981529988888L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String openid;
	
	@Column(name = "check_in_date")
	private Date signDate;
	
	@Column(name = "check_in_benefit")
	private Integer signBenefit;
	
	@Column(name = "check_in_day")
	private Integer signDay;
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Integer getSignBenefit() {
		return signBenefit;
	}

	public void setSignBenefit(Integer signBenefit) {
		this.signBenefit = signBenefit;
	}

	public Integer getSignDay() {
		return signDay;
	}

	public void setSignDay(Integer signDay) {
		this.signDay = signDay;
	}

}
