package com.MasterBranch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Option")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="option_id")
	private int id;
	
	@ManyToOne(targetEntity=Question.class)
    @JoinColumn(name="question_id")
	@JsonBackReference
	private Question question;
	
	private String optionValue;

	public Option() {
	}
	
	public Option(String optionValue) {
		this.optionValue = optionValue;
	}
	
	public Option(Question question, String optionValue) {
		this.question = question;
		this.optionValue = optionValue;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	
	public Question getQuestion() {
		return this.question;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}
}
