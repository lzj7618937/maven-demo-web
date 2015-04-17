package com.maven.demo.entity;

import javax.persistence.*;

import com.maven.common.model.AbstractModel;

/**
 * The persistent class for the springmvc_index database table.
 * 
 */
@Entity
@Table(name = "springmvc_index")
public class IndexModel extends AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "plan_id")
	private int planId;

	@Lob
	private String remark;

	private int sort;

	public IndexModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlanId() {
		return this.planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}