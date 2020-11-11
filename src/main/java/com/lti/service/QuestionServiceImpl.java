package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lti.entity.Question;
import com.lti.entity.SubjectType;
import com.lti.exception.QuestionException;
import com.lti.repository.QuestionRepositoryImpl;

@Service
public class QuestionServiceImpl implements QuestionService {
 
	
	@Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    QuestionRepositoryImpl dao;
    
	
	@Override
	public int addQuestion(Question question) {
		return dao.addQuestion(question);
		
	}

	@Override
	public void deleteQuestion(int id) {
		
	//	 dao.deleteQuestion(id);
		try {
		if(!dao.isQuestionPresent(id))
		{
			throw new QuestionException("Question not present");
		}
		else {
			int id1=dao.findquestion(id).getId();
			dao.deleteQuestion(id1);
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new QuestionException("Question not found");
		}
	}

	

	@Override
	public Question findquestion(int id) {
		
		return dao.findquestion(id);
	}

	@Override
	public List<Question> findQuestionByTopicAndLevel(SubjectType subId, int levelId) {
		return dao.findQuestionByTopicAndLevel(subId, levelId);
		
	}

}
