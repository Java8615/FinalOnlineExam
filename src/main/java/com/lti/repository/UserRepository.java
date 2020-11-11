package com.lti.repository;

import java.util.List;

import com.lti.entity.Result;
import com.lti.entity.User;

public interface UserRepository {

	int save(User user);
    User findById(int id);
    List<User> findAll();
    int findByEmailAndPassword(String email, String password);
    boolean isUserPresent(String email);
	String forgotPassword(String email, String phone);
	int findByEmailAndMobile(String email, String mobile);
	int addResult(Result result, int id);
}


/*
	repository--->service----->controller------->(angular)
*/