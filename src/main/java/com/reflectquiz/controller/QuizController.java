package com.reflectquiz.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reflectquiz.model.Quiz;
import com.reflectquiz.service.QuizService;

@CrossOrigin
@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

	private QuizService qzServ;

	@Autowired
	public QuizController(QuizService qzServ) {
		this.qzServ = qzServ;
	}

	/* Web API for getting Quiz Resource with /id?id=someID
	 * */
	@GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Quiz> getCard(@PathVariable int id) {
		Quiz q = this.qzServ.getQuizById(id);

		// TODO: THROW EXCEPTION INSTEAD
		if (q == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return new ResponseEntity<>(q, HttpStatus.OK);
	}

	// TODO: ADD NULL EXCEPTION HANDLEING
	@GetMapping(path = "/allq", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Quiz>> getAllQuizs() {
		return new ResponseEntity<>(this.qzServ.getAllQuizzes(), HttpStatus.OK);
	}

	//NOTE: ALL JSON POSTS EXPECT SOME KIND OF (questions) ARRAY FROM ANGULAR
	/**
	 * Simply inserts new Quiz object into DB
	 * @param Quiz q: inputed JSON Object expected from Web 
	 * (questions set should either already exist in DB or is empty)
	 * @return: Response entity with inserted question 
	 * */
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Quiz> insertQuiz(@RequestBody Quiz q) {
		this.qzServ.insertQuiz(q);
		return new ResponseEntity<>(q, HttpStatus.ACCEPTED);
	}
	
	/**
	 * Allows for updating of quiz questions set size, (both adding and removing questions)
	 * @param Quiz q: inputed JSON Object with updated questions set
	 * @return: Response entity with inserted question 
	 * */
	@PostMapping(path = "/update/questions", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Quiz> updateQuizQuestions(@RequestBody Quiz q) {
		if(this.qzServ.updateQuizQuestions(q, q.getQuestions()))
			return new ResponseEntity<>(q, HttpStatus.ACCEPTED);
		return new ResponseEntity<>(q, HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Updates Quiz as a whole
	 * @param Quiz q: inputed JSON Object with updated values
	 * @return: Response entity with inserted question 
	 * */
	@PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Quiz> updateQuestion(@RequestBody Quiz q) {
		if(this.qzServ.updateQuiz(q))
			return new ResponseEntity<>(q, HttpStatus.ACCEPTED);
		return new ResponseEntity<>(q, HttpStatus.NO_CONTENT);
	}

}
