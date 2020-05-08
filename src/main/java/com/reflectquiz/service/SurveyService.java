package com.reflectquiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reflectquiz.model.Survey;
import com.reflectquiz.repository.SurveyRepository;
import com.reflectquiz.repository.SurveyRepositoryImpl;

@Service("SurveyService")
public class SurveyService {
	private SurveyRepository survRep;
	
	@Autowired
	public SurveyService(SurveyRepositoryImpl qeRep){
		this.survRep = qeRep;
	}
	
	public List<Survey> getAllSurveys(){
		return this.survRep.getAllSurveys();
	}
	
	public void insertSurvey(Survey inputSurvey) {
		this.survRep.insertSurvey(inputSurvey);
	}
	
	public Survey getSurveyById(int id) {
		return this.survRep.getSurveyById(id);
	}

	
	/**
	 * Updates existing Question.
	 * TODO: Add error handling for same question inputs, (can be checked in controller layer)
	 * @param inputQuestion: Persisted Question object with updated values.  
	 * @return: Boolean, True if success, False otherwise.
	 */
	public boolean updateSurvey(Survey inputSurvey) {
		if(survRep.updateSurvey(inputSurvey))
			return true;
		return false;
	}
}
