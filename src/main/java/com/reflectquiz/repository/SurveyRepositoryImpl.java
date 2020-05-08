package com.reflectquiz.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.reflectquiz.model.Survey;
import com.reflectquiz.util.HibernateConfiguration;


@Repository(value="SurveyRepositoryImpl")
public class SurveyRepositoryImpl implements SurveyRepository {

	/**
	 * Gets All Surveys
	 * @return: list all of Survey objects within DB
	 * */
	public List<Survey> getAllSurveys() {
		List<Survey> allSurvey = new ArrayList<Survey>();
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			allSurvey = currssn.createQuery("FROM Survey", Survey.class).getResultList();
			currtrxn.commit();
		} catch(HibernateException e) {
			currtrxn.rollback();
			e.printStackTrace();
		} finally {
			currssn.close();
		}
		return allSurvey;
	}

	/**
	 * Inserts a new Survey into DB
	 * @param insertSurvey: Survey object to insert into DB 
	 * @return
	 * */
	public void insertSurvey(Survey inputSurvey) {
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			currssn.save(inputSurvey);
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
	public Survey getSurveyById(int inputId) {
		Survey target = null;
		Session currssn = null; 
		Transaction currtrxn = null;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			target = currssn.createQuery("FROM Surveys where id = :id", Survey.class).setParameter("id", inputId).getSingleResult();
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
	public boolean updateSurvey(Survey inputSurvey) {
		Session currssn = null; 
		Transaction currtrxn = null;
		boolean success = false;
		try {
			currssn = HibernateConfiguration.getSession();
			currtrxn = currssn.beginTransaction();
			currssn.update(inputSurvey);
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
