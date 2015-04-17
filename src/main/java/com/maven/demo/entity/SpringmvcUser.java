package com.maven.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the springmvc_user database table.
 * 
 */
@Entity
@Table(name="springmvc_user")
@NamedQuery(name="SpringmvcUser.findAll", query="SELECT s FROM SpringmvcUser s")
public class SpringmvcUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String email;

	@Column(name="last_location")
	private String lastLocation;

	@Column(name="last_login_ip")
	private String lastLoginIp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login_time")
	private Date lastLoginTime;

	private String ncname;

	private String password;

	@Lob
	private String remark;

	private int role;

	private byte status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	private String username;

	public SpringmvcUser() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastLocation() {
		return this.lastLocation;
	}

	public void setLastLocation(String lastLocation) {
		this.lastLocation = lastLocation;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getNcname() {
		return this.ncname;
	}

	public void setNcname(String ncname) {
		this.ncname = ncname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}