package com.MasterBranch.bean;

public class Query {
	private int id;
	private String query;
	private String answer;
	
	public Query() {
		this.id = 0;
		this.query = "";
		this.answer = "";
	}
	
	public Query(int id, String query) {
		this.id = id;
		this.query = query;
		this.answer = "";
	}

	@Override
	public String toString() {
		return "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
