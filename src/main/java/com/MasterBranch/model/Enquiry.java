package com.MasterBranch.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="enquiry_id")
	private int id;
	
	private String name;
	private boolean isDeployed;
	
    @OneToMany(targetEntity=Query.class,mappedBy="enquiry",cascade={CascadeType.ALL},orphanRemoval=true)
	@JsonManagedReference
	private List<Query> queries = new ArrayList<Query>();
	
	public Enquiry() {
	}
	
	public Enquiry(String name, boolean isDeployed) {
		this.name = name;
		this.isDeployed = false;
	}

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
	
	public List<Query> getQueries() {
		return queries;
	}
	
	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}
	
	@Override
	public String toString() {
		return "Inquiry [id=" + id + ", name=" + name + ", isDeployed=" + isDeployed + "]";
	}

}
