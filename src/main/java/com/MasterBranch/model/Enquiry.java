package com.MasterBranch.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Enquiry")
public class Enquiry {
	private int id;
	private String name;
	private boolean isDeployed;
	
	@JsonManagedReference
	private Set<Query> queries;
	
	public Enquiry() {
	}
	
	public Enquiry(String name, boolean isDeployed) {
		this.name = name;
		this.isDeployed = false;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="enquiry_id")
	public int getId() {
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
	
    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="enquiry")
	public Set<Query> getQueries() {
		return queries;
	}
	
	public void setQueries(Set<Query> queries) {
		this.queries = queries;
	}
	
	@Override
	public String toString() {
		return "Inquiry [id=" + id + ", name=" + name + ", isDeployed=" + isDeployed + "]";
	}

}
