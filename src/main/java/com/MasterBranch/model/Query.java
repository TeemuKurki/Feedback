package com.MasterBranch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String question;
	private int questionType;
	private Enquiry enquiry;
	
	public Query() {
	}
	
	public Query(Enquiry enquiry, String question, int questionType) {
		super();
		this.enquiry = enquiry;
		this.question = question;
		this.questionType = questionType;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="query_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	
	public int getQuestionType() {
		return this.questionType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="enquiry_id")
	@JsonBackReference
	public Enquiry getEnquiry() {
		return this.enquiry;
	}
	
	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}

}
