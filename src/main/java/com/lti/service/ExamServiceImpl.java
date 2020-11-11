package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.User;
import com.lti.exception.UserException;
import com.lti.repository.UserRepository;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailService emailService;

	@Override
	public void register(User user) {
		if (!userRepo.isUserPresent(user.getEmail())) {
			int id = userRepo.save(user);
			String nm = user.getFullName();
			String text = "Thank You for registering, " + nm +". Your User Id is " + id;
			String subject = "Registration Confirmation";
			emailService.sendEmailForNewRegistration(user.getEmail(), text, subject);
		} else
			throw new UserException("Customer already registered!");
	}

	/*
	 * @Override public void forgotPwd(String email, String phone) { String psw =
	 * userRepo.forgotPassword(email, phone); if(psw!="abcd") { String text =
	 * "Your Password is:"+psw; String subject = "Remember your password";
	 * emailService.sendEmailForNewRegistration(email, text, subject); }else throw
	 * new UserException("Invalid Email or Phone No"); }
	 */

	@Override
	public void forgotPwd(String email, String mobile) {
		try {
			if (!userRepo.isUserPresent(email))
				throw new UserException("User not Registered");
			else {
				int id = userRepo.findByEmailAndMobile(email, mobile);
				// return userRepo.findById(id).getPassword();
				String pwd = userRepo.findById(id).getPassword();
				String nm = userRepo.findById(id).getFullName();
				String text = "Hello, " + nm + ", Your password is:" + pwd;
				String subject = "Remember your password:";
				emailService.sendEmailForNewRegistration(email, text, subject);
			}
		} catch (Exception e) {
			throw new UserException("Incorrect Email / Mobile No.");
		}
	}

	@Override
	public User login(String email, String password) {
		try {
			if (!userRepo.isUserPresent(email))
				throw new UserException("User not registered!");
			int id = userRepo.findByEmailAndPassword(email, password);
			User user = userRepo.findById(id);
			return user;
		} catch (EmptyResultDataAccessException e) {
			throw new UserException("Incorrect email/password");
		}
	}

	@Override
	public User get(int id) {
		return userRepo.findById(id);
	}

	@Override
	public void update(User user) {
		userRepo.save(user);
	}

}
