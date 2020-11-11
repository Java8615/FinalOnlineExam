package com.lti.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lti.entity.Question;
import com.lti.entity.SubjectType;
import com.lti.entity.User;



@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public int addQuestion(Question question) {
		Question q = em.merge(question);
		return q.getId();
	}

	
	@Override
	public Question findquestion(int id) {
		return em.find(Question.class, id);
	
	}
	@Override
	@Transactional
	public void deleteQuestion(int id) {
		Question q=em.find(Question.class, id);
		if( q!=null) {
			em.remove(q);
		}
//		Question q=em.find(Question.class, id);
//	em.remove(q);
		
		
		

	}


	@Override
	public List<Question> findQuestionByTopicAndLevel(SubjectType subId, int levelId) {
		return (List<Question>)em 
				.createQuery("select q from Question q where q.subId = :sub and q.levelId = :level")
                .setParameter("sub", subId)
                .setParameter("level", levelId)
                .getResultList();
		
	}


	@Override
	public boolean isQuestionPresent(int id) {
		return (Long) em.createQuery("select count(q.id) from Question q where q.id = :em").setParameter("em", id)
				.getSingleResult() == 1 ? true : false;
		//return false;
	}

	


	

}
