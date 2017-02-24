package com.threeMMM.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xiaoyong
 */
@Entity
@Table(name = "rru_messages")
public class MessagesEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4179447200360977559L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String content; // 消息内容
	@Column
	private Integer status; // 接收状态 0未读 1已读 暂时为空
	@Column
	private Date creattime;// 发送时间
	@Column
	private Integer type; // 消息类型 1普通消息
	@Column
	private String fromuserid; // 发送者ID
	@Column
	private String touserid;// 接收者ID

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public String getFromuserid() {
		return fromuserid;
	}

	public void setFromuserid(String fromuserid) {
		this.fromuserid = fromuserid;
	}

	public String getTouserid() {
		return touserid;
	}

	public void setTouserid(String touserid) {
		this.touserid = touserid;
	}

}
