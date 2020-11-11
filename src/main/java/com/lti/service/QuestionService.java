package com.lti.service;

import java.util.List;

import com.lti.entity.Question;
import com.lti.entity.SubjectType;

public interface QuestionService {
int addQuestion(Question question);
	
	void deleteQuestion( int id);
	
	List<Question>findQuestionByTopicAndLevel(SubjectType subId, int levelId);
	public Question findquestion(int id);
}
