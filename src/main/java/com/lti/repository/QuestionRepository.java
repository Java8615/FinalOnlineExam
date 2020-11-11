package com.lti.repository;

import java.util.List;

import com.lti.entity.Question;
import com.lti.entity.SubjectType;

public interface QuestionRepository {
	
	int addQuestion(Question question);
	boolean isQuestionPresent(int id);
	
	void deleteQuestion( int id);
	public Question findquestion(int id);
	
	List<Question>findQuestionByTopicAndLevel(SubjectType subId, int levelId);
	
}
