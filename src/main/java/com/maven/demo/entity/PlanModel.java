package com.maven.demo.entity;

import javax.persistence.*;

import com.maven.common.model.AbstractModel;

import java.util.Date;

/**
 * The persistent class for the springmvc_plan database table.
 * 
 */
@Entity
@Table(name = "springmvc_plan")
public class PlanModel extends AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;

	private String image;

	@Column(name = "num_date")
	private int numDate;

	@Column(name = "num_visit")
	private int numVisit;

	@Lob
	private String remark;

	private String title;

	@Column(name = "user_id")
	private int userId;

	private String username;

	public PlanModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNumDate() {
		return this.numDate;
	}

	public void setNumDate(int numDate) {
		this.numDate = numDate;
	}

	public int getNumVisit() {
		return this.numVisit;
	}

	public void setNumVisit(int numVisit) {
		this.numVisit = numVisit;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}