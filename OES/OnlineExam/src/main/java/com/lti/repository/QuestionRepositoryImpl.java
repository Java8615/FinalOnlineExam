package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Question;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	
	public int addQuestion(Question question) {
		Question q=em.merge(question);
		return q.getId();
	}

	@Override
	public int deleteQuestion(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findQuestionByTopicAndLevel(int topicId, int levelId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
