package com.reflectquiz.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.reflectquiz.model.Question;
import com.reflectquiz.model.Quiz;
import com.reflectquiz.model.User;
import com.reflectquiz.util.HibernateConfiguration;

@Repository(value="QuestionRepositoryImpl")
public class QuestionRepositoryImpl implements QuestionRepository{
	
	/**
	 * Gets All Questions
	 * @return: list all of Question objects within DB
	 * */
	public List<Question> getAllQuestions() {
		List<Question> allQuestions = new ArrayList<Question>();
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			allQuestions = currssn.createQuery("FROM Question", Question.class).getResultList();
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
		return allQuestions;
	}
	/**
	 * Gets All Questions By Topic (Might be antiquated if we handle this with Angular.  
	 * @return: list all of Question objects within DB with specific Topic
	 * */
	public List<Question> getAllQuestionsByTopic(String inputTopic){
		List<Question> target = new ArrayList<Question>();
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
		currssn = HibernateConfiguration.getSession();
		currtrxn = currssn.beginTransaction();
		target = currssn.createQuery("FROM Question where topic = :top", Question.class)
							.setParameter("top", inputTopic).getResultList();
		System.out.println(target);
		currtrxn.commit();
		}
		catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
		return target;
	}
	
	/**
	 * Inserts a new Question into DB
	 * @param inputQuestion: Question object to insert into DB 
	 * @return
	 * */
	public void insertQuestion(Question inputQuestion) {
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			currssn.save(inputQuestion);
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
	}
	
	/**
	 * Gets a Question by their Id
	 * @param inputId: Id to find a Question in DB 
	 * @return target: Question that is found in DB or null otherwise
	 * */
	public Question getQuestionById(int inputId) {
		Question target = null;
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			target = currssn.createQuery("FROM Question where id = :id", Question.class)
								.setParameter("id", inputId).getSingleResult();
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
	 * Updates a Question based on input Question object
	 * @param inputQuiz: Question Object to update (assumes already exists, otherwise error)
	 * 					NOTE: also might be an error if quiz with exact mapping already exists.   
	 * @return success: Boolean True if update succeeded, False otherwise
	 * */
	public boolean updateQuestion(Question inputQuestion) {
		Session currssn = null; 
		Transaction currtrxn = null;
		boolean success = false;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			currssn.update(inputQuestion);
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
