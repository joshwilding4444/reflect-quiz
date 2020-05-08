package com.reflectquiz.testing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

import com.reflectquiz.model.Quiz;
import com.reflectquiz.model.Question;
import com.reflectquiz.repository.QuizRepository;
import com.reflectquiz.repository.QuizRepositoryImpl;
import com.reflectquiz.service.QuizService;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
public class QuizTest {
	
	QuizRepository qd;
	QuizService qServ;
	
	@BeforeAll
	public void setUp() {
		qd = new QuizRepositoryImpl();
		 qServ = new QuizService((QuizRepositoryImpl) qd);
	}
	
	public void testGetQuiz() {
		Quiz testQuiz = qd.getQuizById(3);
		System.out.println(testQuiz.getQuestions());
		Assertions.assertEquals("TOPIC1", testQuiz.getTopic());
	}
	
	
	public void testGetAllQuizs() {
		List<Quiz> lotsOfQuizs = qd.getAllQuizzesByUserId(0);
		Assertions.assertEquals("TOPIC1", lotsOfQuizs.get(0).getTopic());
	}
	
	public void testInsertQuiz() {
		Question q1 = new Question(1,"where is 1", "this 1", "that 1", 1, "TOPIC1", 1);
		Set<Question> s = new HashSet<Question>(Arrays.asList(q1));
		qd.insertQuiz(new Quiz(0, 4, 1, "TOPIC1", s));
	}
	
	public void testUpdateQuiz() {
		Question q1 = new Question(1,"where is 1", "this 1", "that 1", 1, "TOPIC1", 1);
		//Question q2 = new Question(2,"where is 2", "this 2", "that 2", 2, "TOPIC2", 2);
		Set<Question> s = new HashSet<Question>(Arrays.asList(q1));
		Quiz q = new Quiz(3, 4, 1, "TOPIC1", new HashSet<Question>(Arrays.asList(q1)));
		qServ.updateQuizQuestions(q, s);
	}

}
