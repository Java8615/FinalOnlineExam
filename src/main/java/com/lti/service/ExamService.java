package com.lti.service;

import com.lti.entity.Result;
import com.lti.entity.User;

public interface ExamService {


	void register(User user);
    User login(String email, String password);
    User get(int id);
    void update(User user);
	void forgotPwd(String email, String mobile);
	void addResult(Result result, int id);
}
