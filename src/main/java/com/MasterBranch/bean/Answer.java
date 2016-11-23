package com.MasterBranch.bean;

public class Answer {
	private String answer;
	private int id;
	
	public Answer() {
		super();
	}

	public Answer(String answer, int id) {
		super();
		this.answer = answer;
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Answer [answer=" + answer + ", id=" + id + "]";
	}
	
}
