package com.MasterBranch.model;

public class Option {
	private int id;
	private String optionValue;
	
	public Option() {
		this.id = 0;
		this.optionValue = "";
	}
	
	public Option(int id, String optionValue, String type) {
		this.id = id;
		this.optionValue = optionValue;
	}

	public int getId() {
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
}
