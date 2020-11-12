package com.lti.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DeleteDto;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Question;
import com.lti.entity.SubjectType;
import com.lti.exception.QuestionException;
import com.lti.repository.QuestionRepository;
import com.lti.service.QuestionServiceImpl;

@RestController
@CrossOrigin
public class QuestionController {
	@Autowired
	QuestionServiceImpl questionService;

	@PostMapping(path = "/addQuestion")
	public Status add(@RequestBody Question question) {
		try {
			questionService.addQuestion(question);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Question Added ...");
			return status;
		} catch (QuestionException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

	}
	
	@PostMapping(path="/deleteQuestion")
	//@DeleteMapping(path="/deleteQ")
	public Status delete(@RequestBody DeleteDto deletedto)
	{
		try {
			questionService.deleteQuestion(deletedto.getId());
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Question Deleted");
			return status;
		}
		catch (QuestionException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

		
	}
	

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Question getQuestionById(@PathVariable("id") int id) {
		return questionService.findquestion(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/{subId}/{levelId}", method = RequestMethod.GET)
	public List<Question> getQuestionStatement(@PathVariable("subId") SubjectType subId,
			@PathVariable("levelId") int levelId) {
		return questionService.findQuestionByTopicAndLevel(subId, levelId);
	}

	
	

	/* working */
	/*
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE) public
	 * void deleteById(@PathVariable("id") int id) {
	 * questionService.deleteQuestion(id); }
	 */

}

/*
 * @Autowired private QuestionRepository questionRepository;
 * 
 * @PostMapping(path ="/addQuestion") public Status add(@RequestBody Question
 * question) { try { questionRepository.addQuestion(question); Status status =
 * new Status(); status.setStatus(StatusType.SUCCESS);
 * status.setMessage("Registration successful!"); return status; } catch
 * (QuestionException e) { Status status = new Status();
 * status.setStatus(StatusType.FAILURE); status.setMessage(e.getMessage());
 * return status; }
 * 
 * }
 */
