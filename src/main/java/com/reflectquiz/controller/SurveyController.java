package com.reflectquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reflectquiz.model.Survey;
import com.reflectquiz.service.SurveyService;

@RestController
@RequestMapping(value="/Survey")
public class SurveyController {

	private SurveyService survServ;
	
	@Autowired
	public SurveyController(SurveyService qeServ) {
		this.survServ = qeServ;
	}

	
	@GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Survey> getCard(@PathVariable int id) {
		Survey s = this.survServ.getSurveyById(id);
		
		//TODO: THROW EXCEPTION INSTEAD
		if(s == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	// TODO: ADD NULL EXCEPTION HANDLEING
	@GetMapping(path = "/alls", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Survey>> getAllSurveys(){
		return new ResponseEntity<>(this.survServ.getAllSurveys(), HttpStatus.OK);
	}

	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Survey> insertSurvey(@RequestBody Survey s) {
		this.survServ.insertSurvey(s);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}
	

	@PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Survey> updateSurvey(@RequestBody Survey s) {
		if(this.survServ.updateSurvey(s))
			return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
		return new ResponseEntity<>(s, HttpStatus.NO_CONTENT);
	}
}
