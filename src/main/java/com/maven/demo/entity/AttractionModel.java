package com.maven.demo.entity;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.maven.common.model.AbstractModel;


/**
 * The persistent class for the springmvc_attraction database table.
 * 
 */
@Entity
@Table(name="springmvc_attraction")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AttractionModel  extends AbstractModel  {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	private int id;

	@Lob
	@Column(name="best_time")
	private String bestTime;

	private String city;

	@Lob
	private String contact;

	private String image;

	@Lob
	@Column(name="open_time")
	private String openTime;

	@Lob
	private String price;

	private String province;

	@Lob
	private String remark;

	@Lob
	private String tel;

	private String title;

	@Lob
	private String traffic;

	public AttractionModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTraffic() {
		return this.traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

}