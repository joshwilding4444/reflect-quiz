package com.reflectquiz.repository;

import java.util.List;

import com.reflectquiz.model.Quiz;

public interface QuizRepository {
	List<Quiz> getAllQuizzesByUserId(int userId);
	void insertQuiz(Quiz inputQuiz);
	Quiz getQuizById(int inputId);
	boolean updateQuiz(Quiz inputQuiz);
}
