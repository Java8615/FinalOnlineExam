package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Question;
import com.lti.exception.QuestionException;
import com.lti.repository.QuestionRepository;

@RestController
@CrossOrigin
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@PostMapping(path ="/addQuestion")
	public Status add(@RequestBody Question question) {
		try {
			questionRepository.addQuestion(question);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration successful!");
			return status;
		} catch (QuestionException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
	

	
}
