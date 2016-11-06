package com.MasterBranch.bean;

import java.util.List;

public class Enquiry {
	private int id;
	private String name;
	private boolean isDeployed;
	private List<Query> queries;
	
	public Enquiry() {
		super();
		this.id = 0;
		this.name = "";
		this.isDeployed = false;
	}
	
	public Enquiry(int id, String name) {
		this.id = id;
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
