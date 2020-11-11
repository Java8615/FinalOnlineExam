package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user861")
@NamedQuery(name = "fetch-all",query=" select u from User u")
public class User {

	@Id
	@SequenceGenerator(name = "userSeq", initialValue = 101, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
	@Column(name = "user_id")
	int userId;

	@Column(name = "user_fullname")
	String fullName;

	@Column(name = "user_email")
	String email;

	@Column(name = "user_mobile")
	String mobile;

	@Column(name = "user_city")
	String city;

	@Column(name = "user_state")
	String state;

	@Column(name = "user_date_of_birth")
	LocalDate dateOfBirth;

	@Column(name = "user_qualification")
	String qualification;

	@Column(name = "user_year_of_completion")
	LocalDate yearOfCompletion;

	
	
	@Column(name = "user_password")
	String password;

	@OneToMany(mappedBy = "user")
	List<Result> results;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public LocalDate getYearOfCompletion() {
		return yearOfCompletion;
	}

	public void setYearOfCompletion(LocalDate yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
