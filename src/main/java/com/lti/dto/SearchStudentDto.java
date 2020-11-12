package com.lti.dto;

import com.lti.entity.SubjectType;

public class SearchStudentDto {
	
	SubjectType subId;
	String state;
	String city;
	int totalMarks;
	public SubjectType getSubId() {
		return subId;
	}
	public void setSubId(SubjectType subId) {
		this.subId = subId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
}
