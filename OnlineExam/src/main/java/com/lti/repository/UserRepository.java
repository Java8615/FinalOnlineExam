package com.lti.repository;

import java.util.List;

import com.lti.entity.User;

public interface UserRepository {

	int save(User user);
    User findById(int id);
    List<User> findAll();
    int findByEmailAndPassword(String email, String password);
    boolean isUserPresent(String email);
}


/*
	repository--->service----->controller------->(angular)
*/