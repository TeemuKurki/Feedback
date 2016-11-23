package com.MasterBranch.bean;

import java.util.List;

public class Query {
	private int id;
	private int dbId;
	private String query;
	private List<Answer> answer;
	
	public Query() {
		this.id = 0;
		this.query = "";
		this.dbId = 0;
	}
	
	public Query(int id, String query, int dbId) {
		this.id = id;
		this.query = query;
		this.dbId = dbId;
	}

	public int getDbId() {
		return dbId;
	}

	public void setDbId(int dbId) {
		this.dbId = dbId;
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<Answer> getAnswer() {
		return answer;
	}
	
	public void addAnswer(Answer a) {
		if(answer != null) answer.add(a);
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
}
