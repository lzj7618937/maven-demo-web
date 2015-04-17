package com.maven.demo.entity;

import javax.persistence.*;

import com.maven.common.model.AbstractModel;

/**
 * The persistent class for the springmvc_region database table.
 * 
 */
@Entity
@Table(name = "springmvc_region")
public class RegionModel extends AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	private String name;

	private int pid;

	private byte type;

	public RegionModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

}