package com.reflectquiz.repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.reflectquiz.model.User;
import com.reflectquiz.util.HibernateConfiguration;

@Repository(value="UserDataRepositoryImpl")
public class UserDataRepositoryImpl implements UserDataRepository {
	
	/**
	 * Gets All Users
	 * @return: list all of User objects within DB
	 * */
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
	
	/**
	 * Inserts a new user into DB
	 * @param inputUser: User object to insert into DB 
	 * @return
	 * */
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
	
	/**
	 * Gets a User by their username
	 * @param inputUser: Username to find a User in DB 
	 * @return target: User that is found in DB or null otherwise
	 * */
	public User getUserByUsername(String inputUser) {
		User target = null;
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			target = currssn.createQuery("FROM User where username = :user", User.class)
								.setParameter("user", inputUser).getSingleResult();
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} 
		catch(NoResultException e) {
			currtrxn.rollback();
			e.printStackTrace();
		}
		finally {
			currssn.close();
		}
		return target;
	}
}
