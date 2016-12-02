package com.MasterBranch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Query")
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int enquiry_id;
	private String question;
	private int questionType; // 0 = default/string, 1 = checkbox/Options
	
	//private List<Option> options;
	//private List<Answer> answer;
	
	protected Query() {
	}
	
	public Query(String question, int questionType) {
		super();
		this.question = question;
		this.questionType = questionType;
	}

	
	/*
	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	*/

	public int enquiryId() {
		return enquiry_id;
	}


	@Override
	public String toString() {
		return "";
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setEnquiryId(int enquiry_id) {
		this.enquiry_id = enquiry_id;
	}

	public void setQueryType(int questionType) {
		this.questionType = questionType;
	}
	
	public int getQueryType() {
		return this.questionType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuery(String question) {
		this.question = question;
	}
	
	/*
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
	*/
}
