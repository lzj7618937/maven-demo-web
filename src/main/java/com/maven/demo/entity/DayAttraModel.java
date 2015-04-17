package com.maven.demo.entity;

import javax.persistence.*;

import com.maven.common.model.AbstractModel;


/**
 * The persistent class for the springmvc_day_attra database table.
 * 
 */
@Entity
@Table(name="springmvc_day_attra")
public class DayAttraModel extends AbstractModel  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name="attra_id")
	private int attraId;

	@Column(name="attra_name")
	private String attraName;

	@Column(name="dayplan_id")
	private int dayplanId;

	@Lob
	private String remark;

	private int sort;

	public DayAttraModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttraId() {
		return this.attraId;
	}

	public void setAttraId(int attraId) {
		this.attraId = attraId;
	}

	public String getAttraName() {
		return this.attraName;
	}

	public void setAttraName(String attraName) {
		this.attraName = attraName;
	}

	public int getDayplanId() {
		return this.dayplanId;
	}

	public void setDayplanId(int dayplanId) {
		this.dayplanId = dayplanId;
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