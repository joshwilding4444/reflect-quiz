package com.reflectquiz.repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.reflectquiz.model.User;
import com.reflectquiz.util.HibernateConfiguration;

@Repository(value="UserDataImpl")
public class UserDataRepositoryImpl implements UserDataRepository {
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			allUsers = currssn.createQuery("FROM User", User.class).getResultList();
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
		return allUsers;
	}
	
	public void insertUser(User inputUser) {
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			currssn.save(inputUser);
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
	}
	
	public User getUserById(int inputID) {
		User target = null;
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			target = currssn.createQuery("FROM User where id = :userid", User.class)
								.setParameter("userid", inputID).getSingleResult();
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
		return target;
	}
}
