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
import com.reflectquiz.repository.QuestionRepository;
import com.reflectquiz.repository.QuestionRepositoryImpl;
import com.reflectquiz.service.QuestionService;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
public class QuestionTest {
	
	QuestionRepository qd;
	QuestionService qServ;
	
	@BeforeAll
	public void setUp() {
		qd = new QuestionRepositoryImpl();
		 qServ = new QuestionService((QuestionRepositoryImpl) qd);
	}
	
	public void testGetQuestion() {
		Question testQuestion = qd.getQuestionById(1);
		//System.out.println(testQuestion.getQuestions());
		Assertions.assertEquals("TOPIC1", testQuestion.getTopic());
	}
	
	
	public void testGetAllQuestions() {
		//List<Question> lotsOfQuizs = qd.getAllQuestionzesByUserId(0);
		//Assertions.assertEquals("TOPIC1", lotsOfQuestions.get(0).getTopic());
	}
	
	public void testInsertQuestion() {
		//Question q1 = new Question(0,"where is 1", "this 1", "that 1", 1, "TOPIC1", 1);
		Question q2 = new Question(0,"where is 2", "this 2", "that 2", 2, "TOPIC2", 2);
		qd.insertQuestion(q2);
	}
	
	public void testUpdateQuestion() {
		Question q1 = new Question(1,"where is 1 new", "this 1 new", "that 1 new", 1, "TOPIC1", 1);
		Question q2 = new Question(2,"where is 2", "this 2", "that 2", 2, "TOPIC2", 2);
		Set<Question> s = new HashSet<Question>(Arrays.asList(q1, q2));
		qServ.updateQuestion(q1);
		//Question q = new Question(1, 4, 1, "TOPIC1", new HashSet<Question>(Arrays.asList(q1)));
		//qServ.updateQuestion(q, s);
	}

}
