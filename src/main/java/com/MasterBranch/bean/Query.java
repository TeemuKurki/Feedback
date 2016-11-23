package com.MasterBranch.bean;

import java.util.List;

public class Query {
	private int id;
	private int dbId;
	private String query;
	private int queryType; // 0 = default/string, 1 = checkbox/Options
	private List<Option> options;
	private String answer;
	
	public Query() {
		this.id = 0;
		this.queryType = 0;
		this.query = "";
		this.answer = "";
	}
	
	public Query(int id, int dbId, int type, String query) {
		this.id = id;
		this.dbId = dbId;
		this.query = query;
		this.queryType = type;
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
	
	public int getDbId() {
		return this.dbId;
	}
	
	public void setDbId(int dbId) {
		this.dbId = dbId;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public void setQueryType(int type) {
		this.queryType = type;
	}
	
	public int getQueryType() {
		return this.queryType;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
}
