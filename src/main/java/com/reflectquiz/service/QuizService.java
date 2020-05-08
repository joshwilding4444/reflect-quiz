package com.reflectquiz.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reflectquiz.model.Question;
import com.reflectquiz.model.Quiz;
import com.reflectquiz.repository.QuizRepository;
import com.reflectquiz.repository.QuizRepositoryImpl;

@Service("QuizService")
public class QuizService {
    
	private QuizRepository qzRep;
	
	@Autowired
	public QuizService(QuizRepositoryImpl qzRep){
		this.qzRep = qzRep;
	}
	
	//TODO: Convert to get all by user ID
	public List<Quiz> getAllQuizzes(){
		return this.qzRep.getAllQuizzesByUserId(0);
	}
	
	public void insertQuiz(Quiz inputQuiz) {
		this.qzRep.insertQuiz(inputQuiz);
	}
	
	public Quiz getQuizById(int id) {
		return this.qzRep.getQuizById(id);
	}
	
	/**
	 * Updates Quiz with the given set of questions. Questions should be unique.
	 * TODO: Add error handling for same question inputs, (can be checked in controller layer)
	 * @param inputQuiz: Quiz object that will be updated.  
	 * @param inputQuestions: Questions to add to quiz.
	 * @return: Boolean, True if success, False otherwise.
	 */
	public boolean updateQuizQuestions(Quiz inputQuiz, Set<Question> inputQuestions) {
		inputQuiz.setQuestions(inputQuestions);
		if(qzRep.updateQuiz(inputQuiz))
			return true;
		return false;
	}
	
	/**
	 * Updates existing quiz.
	 * TODO: Add error handling for same question inputs, (can be checked in controller layer)
	 * @param inputQuiz: Persisted Quiz object with updated values.  
	 * @return: Boolean, True if success, False otherwise.
	 */
	public boolean updateQuiz(Quiz inputQuiz) {
		if(qzRep.updateQuiz(inputQuiz))
			return true;
		return false;
	}
	
}
