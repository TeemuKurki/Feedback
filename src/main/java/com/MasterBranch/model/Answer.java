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
@Table(name = "Answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="answer_id")
	private int id;
	
	@ManyToOne(targetEntity=Question.class)
    @JoinColumn(name="question_id")
	@JsonBackReference
	private Question question;
	
	private String answer;
	private int radioButton = 0;
	
	
	
	public Answer() {
	}

	public Answer(String answer) {
		this.answer = answer;
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

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [answer=" + answer + ", id=" + id + "]";
	}

	public int getRadioButton() {
		return radioButton;
	}

	public void setRadioButton(int radioButton) {
		this.radioButton = radioButton;
	}
	
}
