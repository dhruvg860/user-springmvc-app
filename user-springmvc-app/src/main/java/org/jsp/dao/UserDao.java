package org.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	EntityManager m;

	public User saveUser(User user) {
		m.persist(user);
		EntityTransaction t = m.getTransaction();
		t.begin();
		t.commit();
		return user;
	}
	public User updateUser(User u)
	{
		m.merge(u);
		EntityTransaction t = m.getTransaction();
		t.begin();
		t.commit();
		return u;
	}

}
