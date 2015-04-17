package com.maven.demo.entity;

import javax.persistence.*;

import com.maven.common.model.AbstractModel;


/**
 * The persistent class for the springmvc_category database table.
 * 
 */
@Entity
@Table(name="springmvc_category")
public class CategoryModel  extends AbstractModel  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name="category_name")
	private String categoryName;

	private String image;

	@Lob
	private String remark;

	public CategoryModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}