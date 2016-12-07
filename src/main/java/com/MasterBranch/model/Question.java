package com.MasterBranch.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Question")
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="question_id")
	private int id;
	
	@ManyToOne(targetEntity=Enquiry.class)
    @JoinColumn(name="enquiry_id")
	@JsonBackReference
	private Enquiry enquiry;
	
	private String question;
	private int questionType;
	
	@OneToMany(targetEntity=Option.class,mappedBy="question",cascade={CascadeType.ALL},orphanRemoval=true)
	@JsonManagedReference
	private List<Option> options = new ArrayList<Option>();
	
	public Question() {
	}
	
	public Question(Enquiry enquiry, String question, int questionType) {
		super();
		this.enquiry = enquiry;
		this.question = question;
		this.questionType = questionType;
	}

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
	
	public Enquiry getEnquiry() {
		return this.enquiry;
	}
	
	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}
	
	public List<Option> getOptions() {
		return options;
	}
	
	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
