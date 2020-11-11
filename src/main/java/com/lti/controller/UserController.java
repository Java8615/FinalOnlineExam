package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ForgotPasswordDto;
import com.lti.dto.LoginDto;
import com.lti.dto.LoginStatus;
import com.lti.dto.ResultDto;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.User;
import com.lti.exception.UserException;
import com.lti.service.ExamService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private ExamService examService;

	@PostMapping(path = "/register")
	public Status register(@RequestBody User user) {
		try {
			examService.register(user);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration successful!");
			return status;
		} catch (UserException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping(path = "/addResult")
	public Status addResult(@RequestBody ResultDto resultdto) {
		try {
			examService.addResult(resultdto.getResult(), resultdto.getId());
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration successful!");
			return status;
		}catch (UserException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/login")
	public LoginStatus login(@RequestBody LoginDto loginDto) {
		try {
			User user = examService.login(loginDto.getEmail(), loginDto.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful!");
			loginStatus.setCustomerId(user.getUserId());
			loginStatus.setName(user.getFullName());
			return loginStatus;
		} catch (UserException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
	}

	@PostMapping("/forgot_password")
	public Status forgotPsw(@RequestBody ForgotPasswordDto forgotPasswordDto) {
		try {
			examService.forgotPwd(forgotPasswordDto.getEmail(), forgotPasswordDto.getMobile());
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Password sent to your registered Email");
			return status;
		} catch (Exception e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
