package com.reflectquiz.controller;

import java.util.List;

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

import com.reflectquiz.model.Question;
import com.reflectquiz.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping(value="/question")
public class QuestionController {
	
	private QuestionService qeServ;
	
	@Autowired
	public QuestionController(QuestionService qeServ) {
		this.qeServ = qeServ;
	}

	
	@GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Question> getCard(@PathVariable int id) {
		Question q = this.qeServ.getQuestionById(id);
		
		//TODO: THROW EXCEPTION INSTEAD
		if(q == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return new ResponseEntity<>(q, HttpStatus.OK);
	}
	@GetMapping(path = "/topic/{topic}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Question>> getCard(@PathVariable String topic) {
		List<Question> ql = this.qeServ.getAllQuestionsByTopic(topic);
		
		//TODO: THROW EXCEPTION INSTEAD
		if(ql == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return new ResponseEntity<>(ql, HttpStatus.OK);
	}
	
	// TODO: ADD NULL EXCEPTION HANDLEING
	@GetMapping(path = "/allq", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Question>> getAllQuestions(){
		return new ResponseEntity<>(this.qeServ.getAllQuestions(), HttpStatus.OK);
	}

	/**
	 * Simply Inserts new question into DB
	 * @param Question q: inputed JSON Object expected from Web
	 * @return: Response entity with inserted question 
	 * */
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Question> insertQuestion(@RequestBody Question q) {
		this.qeServ.insertQuestion(q);
		return new ResponseEntity<>(q, HttpStatus.ACCEPTED);
	}
	
	/**
	 * Simply Inserts new question into DB
	 * @param Question q: inputed JSON Object expected from Web
	 * @return: Response entity with inserted question 
	 * */
	@PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Question> updateQuestion(@RequestBody Question q) {
		if(this.qeServ.updateQuestion(q))
			return new ResponseEntity<>(q, HttpStatus.ACCEPTED);
		return new ResponseEntity<>(q, HttpStatus.NO_CONTENT);
	}
}
