package com.MasterBranch.model;

import java.util.List;

public class Query {
	private int id;
	private int dbId;
	private String query;
	private int queryType; // 0 = default/string, 1 = checkbox/Options
	private List<Option> options;
	private List<Answer> answer;
	
	public Query() {
		super();
		this.id = 0;
		this.queryType = 0;
		this.query = "";
		this.dbId = 0;
	}
	
	public Query(int id, int dbId, int type, String query) {
		this.id = id;
		this.dbId = dbId;
		this.query = query;
		this.queryType = type;
	}

	
	
	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public int getDbId() {
		return dbId;
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
	
	public void setDbId(int dbId) {
		this.dbId = dbId;
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
	
	public void addOption(Option option) {
		if(this.options != null) {
			this.options.add(option);
		}
	}
	
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	public List<Option> getOptions() {
		return this.options;
	}
	
}
