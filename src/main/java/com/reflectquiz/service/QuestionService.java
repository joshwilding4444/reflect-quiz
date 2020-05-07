package com.reflectquiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reflectquiz.model.Question;
import com.reflectquiz.model.Quiz;
import com.reflectquiz.repository.QuestionRepository;
import com.reflectquiz.repository.QuestionRepositoryImpl;

@Service("QuestionService")
public class QuestionService {
    
	private QuestionRepository qeRep;
	
	@Autowired
	public QuestionService(QuestionRepositoryImpl qeRep){
		this.qeRep = qeRep;
	}
	
	public List<Question> getAllQuestions(){
		return this.qeRep.getAllQuestions();
	}
	
	public void insertQuestion(Question inputQuestion) {
		this.qeRep.insertQuestion(inputQuestion);
	}
	
	public Question getQuestionById(int id) {
		return this.qeRep.getQuestionById(id);
	}
	public List<Question> getAllQuestionsByTopic(String inputTopic){
		return this.qeRep.getAllQuestionsByTopic(inputTopic);
	}
	
	/**
	 * Updates existing Question.
	 * TODO: Add error handling for same question inputs, (can be checked in controller layer)
	 * @param inputQuestion: Persisted Question object with updated values.  
	 * @return: Boolean, True if success, False otherwise.
	 */
	public boolean updateQuestion(Question inputQuestion) {
		if(qeRep.updateQuestion(inputQuestion))
			return true;
		return false;
	}
}
