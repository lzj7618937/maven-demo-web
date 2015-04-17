package com.maven.demo.entity;

import javax.persistence.*;

import com.maven.common.model.AbstractModel;

import java.util.Date;

/**
 * The persistent class for the springmvc_dayplan database table.
 * 
 */
@Entity
@Table(name = "springmvc_dayplan")
public class DayplanModel extends AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "plan_id")
	private int planId;

	@Lob
	private String remark;

	private int sort;

	public DayplanModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DayplanModel other = (DayplanModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

}