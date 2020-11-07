package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_result")
public class Result {

	@Id
	@SequenceGenerator(name = "resSeq", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resSeq")
	@Column(name = "result_id")
	int resultId;

	@Column(name = "result_level1_result")
	int level1Result;

	@Column(name = "result_level2_result")
	int level2Result;

	@Column(name = "result_level3_result")
	int level3Result;

	@Column(name = "result_total_score")
	int totalScore;

	@Column(name = "result_subject_id")
	SubjectType subjectId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getLevel1Result() {
		return level1Result;
	}

	public void setLevel1Result(int level1Result) {
		this.level1Result = level1Result;
	}

	public int getLevel2Result() {
		return level2Result;
	}

	public void setLevel2Result(int level2Result) {
		this.level2Result = level2Result;
	}

	public int getLevel3Result() {
		return level3Result;
	}

	public void setLevel3Result(int level3Result) {
		this.level3Result = level3Result;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SubjectType getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(SubjectType subjectId) {
		this.subjectId = subjectId;
	}

}
