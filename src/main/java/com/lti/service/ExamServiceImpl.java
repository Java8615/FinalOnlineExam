package com.lti.service;

import javax.mail.search.SubjectTerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Result;
import com.lti.entity.SubjectType;
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


	@Override
	public void addResult(Result result, int id) {
		int id1 = userRepo.addResult(result, id);
		int l1s = result.getLevel1Result();
		int l2s = result.getLevel2Result();
		int l3s = result.getLevel3Result();
		int tots = result.getTotalScore();
		SubjectType sub = result.getSubjectId();
		String name =  result.getUser().getFullName();
		String email = result.getUser().getEmail();
		String text = "Test Completed, "+name+". Your result for Subject "+sub+" is : Level 1: "+l1s+" Level 2: "+l2s+" Level 3: "+l3s+". Your total score is = "+tots+".";
		String subject  = "Report Card for Test: "+sub;
		emailService.sendEmailForNewRegistration(email, text, subject);
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
