package com.maven.demo.entity;

import javax.persistence.*;

import com.maven.common.model.AbstractModel;

/**
 * The persistent class for the springmvc_attr_category database table.
 * 
 */
@Entity
@Table(name = "springmvc_attr_category")
public class AttrCategoryModel extends AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "attra_id")
	private int attraId;

	@Column(name = "category_id")
	private int categoryId;

	public AttrCategoryModel() {
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

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}