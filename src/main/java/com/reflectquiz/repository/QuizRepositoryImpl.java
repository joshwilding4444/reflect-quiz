package com.reflectquiz.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.reflectquiz.model.Quiz;
import com.reflectquiz.util.HibernateConfiguration;

@Repository(value="QuizRepositoryImpl")
public class QuizRepositoryImpl implements QuizRepository{

	/**
	 * Gets All Quizzes
	 * @return: list all of the Quiz objects within DB
	 * */
	public List<Quiz> getAllQuizzesByUserId(int userId) {
		List<Quiz> allQuizzes = new ArrayList<Quiz>();
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			//TODO: Add get by User ID support
			allQuizzes = currssn.createQuery("FROM Quiz", Quiz.class).getResultList();
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
		return allQuizzes;
	}
	
	/**
	 * Inserts a new Quiz into DB
	 * @param inputQuiz: Quiz object to insert into DB 
	 * @return
	 * */
	public void insertQuiz(Quiz inputQuiz) {
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			currssn.save(inputQuiz);
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
	}
	
	/**
	 * Gets a Quiz by their Id
	 * @param inputId: Id to find a Quiz in DB 
	 * @return target: Quiz that is found in DB or null otherwise
	 * */
	public Quiz getQuizById(int inputId) {
		Quiz target = null;
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			target = currssn.get(Quiz.class, inputId);
			//target = currssn.createQuery("FROM Quiz where id = :id", Quiz.class)
								//.setParameter("id", inputId).getSingleResult();
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
		return target;
	}
	
	/**
	 * Updates a Quiz based on input Quiz object
	 * @param inputQuiz: Quiz Object to update (assumes already exists, otherwise error)
	 * 					NOTE: also might be an error if quiz with exact mapping already exists.   
	 * @return success: Boolean True if update succeeded, False otherwise
	 * */
	public boolean updateQuiz(Quiz inputQuiz) {
		Session currssn = null; 
		Transaction currtrxn = null;
		boolean success = false;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			currssn.update(inputQuiz);
			currtrxn.commit();
			success =  true;
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
		return success;
	}

}
