package com.MasterBranch.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enquiry {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private boolean isDeployed;
	private List<Query> queries;
	
	public Enquiry() {
		super();
	}
	
	public Enquiry(int id, String name) {
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
	
	public void addQuery(Query q) {
		if(queries != null) {
			queries.add(q);
		}
	}

	public List<Query> getQueries() {
		return queries;
	}

	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}

	@Override
	public String toString() {
		return "Inquiry [id=" + id + ", name=" + name + ", isDeployed=" + isDeployed + ", queries=" + queries + "]";
	}

}
