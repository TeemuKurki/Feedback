package com.MasterBranch.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Option")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="option_id")
	private int id;
	
	@ManyToOne(targetEntity=Query.class)
    @JoinColumn(name="query_id")
	@JsonBackReference
	private Query query;
	
	private String optionValue;

	public Option() {
	}
	
	public Option(String optionValue) {
		this.optionValue = optionValue;
	}
	
	public Option(Query query, String optionValue) {
		this.query = query;
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
	
	public Query getQuery() {
		return this.query;
	}
	
	public void setQuery(Query query) {
		this.query = query;
	}
}
