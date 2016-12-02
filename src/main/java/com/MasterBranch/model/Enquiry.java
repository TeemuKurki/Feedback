package com.MasterBranch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Enquiry")
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private boolean isDeployed;
	
	public Enquiry() {
		super();
	}
	
	public Enquiry(int id, String name, boolean isDeployed) {
		this.id = id;
		this.name = name;
		this.isDeployed = false;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeployed() {
		return isDeployed;
	}

	public void setDeployed(boolean isDeployed) {
		this.isDeployed = isDeployed;
	}

	@Override
	public String toString() {
		return "Inquiry [id=" + id + ", name=" + name + ", isDeployed=" + isDeployed + "]";
	}

}
