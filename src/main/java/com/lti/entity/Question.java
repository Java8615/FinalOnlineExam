package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_questions861")
public class Question {

	@Id
	@SequenceGenerator(name = "qnSeq", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qnSeq")
	@Column(name = "qn_id")
	private int id;
	@Column(name = "level_id")
	private int levelId;
	@Column(name = "subject_id")
	private SubjectType subId;
	@Column(name = "question_Statement")
	private String questionStatement;
	@Column(name = "option_1")
	private String option1;
	@Column(name = "option_2")
	private String option2;
	@Column(name = "option_3")
	private String option3;
	@Column(name = "option_4")
	private String option4;
	@Column(name = "correct_answer")
	private String correctAnswer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	

	public SubjectType getSubId() {
		return subId;
	}

	public void setSubId(SubjectType subId) {
		this.subId = subId;
	}

	public String getQuestionStatement() {
		return questionStatement;
	}

	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", levelId=" + levelId + ", subId=" + subId + ", questionStatement="
				+ questionStatement + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3
				+ ", option4=" + option4 + ", correctAnswer=" + correctAnswer + "]";
	}

	

}
