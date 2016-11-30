package com.MasterBranch.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @NotNull
	private String answer;
	
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

	public long getId() {
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
