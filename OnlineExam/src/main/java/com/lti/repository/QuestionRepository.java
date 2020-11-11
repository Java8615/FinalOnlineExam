package com.lti.repository;

import com.lti.entity.Question;

public interface QuestionRepository {
	
	int addQuestion(Question question);
	
	int deleteQuestion( int id);
	
	int findQuestionByTopicAndLevel(int topicId,int levelId);
	
}
