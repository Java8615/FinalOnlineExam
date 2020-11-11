package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Result;
import com.lti.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public int save(User user) {
		User u = em.merge(user);
		return u.getUserId();
	}

	@Override
	public User findById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> findAll() {
		return em.createNamedQuery("fetch-all").getResultList();
	}

	@Override
	public int findByEmailAndPassword(String email, String password) {
		return (Integer) em.createQuery("select u.userId from User u where u.email = :em and u.password = :pw")
				.setParameter("em", email).setParameter("pw", password).getSingleResult();
	}
	
	@Override
	public int findByEmailAndMobile(String email, String mobile) {
		return (Integer) em.createQuery("select u.userId from User u where u.email = :em and u.mobile = :mob")
				.setParameter("em", email).setParameter("mob", mobile).getSingleResult();
	}

	@Override
	public boolean isUserPresent(String email) {
		return (Long) em.createQuery("select count(u.userId) from User u where u.email = :em").setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	public String forgotPassword(String email, String phone) {
		Query query = em.createQuery("select u.password from User u where u.email=:em and u.mobile =:ph");
		query.setParameter("em", email);
		query.setParameter("ph", phone);
		try {
			User user = (User) query.getSingleResult();
			return user.getPassword();
		} catch (Exception e) {
			return "abcd";
		}
	}

	@Override
	@Transactional
	public int addResult(Result result, int id) {
		User user = findById(id);
		result.setUser(user);
		em.merge(result);
		return result.getResultId();
	}
	

	
}
