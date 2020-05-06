package com.reflectquiz.repository;

import java.util.List;

import com.reflectquiz.model.Question;

public interface QuestionRepository {
	List<Question> getAllQuestions();
	void insertQuestion(Question inputQuestion);
	Question getQuestionById(int inputId);
	List<Question> getAllQuestionsByTopic(String inputTopic); //might be antiquated
	boolean updateQuestion(Question inputQuestion);
}