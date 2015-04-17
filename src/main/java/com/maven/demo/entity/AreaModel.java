package com.maven.demo.entity;

import javax.persistence.*;

import com.maven.common.model.AbstractModel;


/**
 * The persistent class for the springmvc_area database table.
 * 
 */
@Entity
@Table(name="springmvc_area")
public class AreaModel  extends AbstractModel   {
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name="area_name")
	private String areaName;

	@Lob
	private String attention;

	@Lob
	@Column(name="best_time")
	private String bestTime;

	@Lob
	private String eat;

	private String firstPY;

	@Lob
	private String folk;

	private String image;

	@Lob
	private String intro;

	@Column(name="num_visit")
	private int numVisit;

	@Column(name="parent_id")
	private String parentId;

	@Lob
	private String remark;

	@Lob
	private String traffic;

	public AreaModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAttention() {
		return this.attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	public String getEat() {
		return this.eat;
	}

	public void setEat(String eat) {
		this.eat = eat;
	}

	public String getFirstPY() {
		return this.firstPY;
	}

	public void setFirstPY(String firstPY) {
		this.firstPY = firstPY;
	}

	public String getFolk() {
		return this.folk;
	}

	public void setFolk(String folk) {
		this.folk = folk;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getNumVisit() {
		return this.numVisit;
	}

	public void setNumVisit(int numVisit) {
		this.numVisit = numVisit;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTraffic() {
		return this.traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

}