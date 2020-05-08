package com.reflectquiz.repository;

import com.reflectquiz.model.Survey;
import java.util.List;

public interface SurveyRepository {
	List<Survey> getAllSurveys();
	void insertSurvey(Survey inputSurvey);
	Survey getSurveyById(int inputId);
	boolean updateSurvey(Survey inputSurvey);
}
