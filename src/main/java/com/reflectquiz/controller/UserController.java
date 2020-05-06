package com.reflectquiz.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reflectquiz.model.User;
import com.reflectquiz.repository.UserDataRepositoryImpl;
import com.reflectquiz.service.UserService;

@RestController("UserController")
@RequestMapping(path = "/users")
public class UserController {
	
	private UserService ctrlService;
	
	@Autowired
	public UserController(UserService ctrlService) {
		this.ctrlService = ctrlService;
	}
	/**
	 * Returns a JSON string representing all users
	 * @param:
	 * @return: JSON string containing information about all users
	 * */
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(this.ctrlService.getAllUsers(), HttpStatus.OK);
	}
	
	/**
	 * Returns a JSON string representing a single user
	 * @param name: input name of a user
	 * @return: JSON string containing information about the user found, if any
	 * */
	@GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUserByUsername(@PathVariable String name) {
		return new ResponseEntity<User>(this.ctrlService.getUserByUsername(name), HttpStatus.OK);
	}
	
	/**
	 * Returns a JSON string telling whether or not authentication was successful.
	 * @param name: input name of a user
	 * @param password: input password of user
	 * @return: JSON string containing result of authentication. 
	 * */
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Boolean> authenticate(@RequestBody String inputJSON) {
		ObjectMapper userMapper = new ObjectMapper();
		User inputUser = null;
		try {
			inputUser = (User) userMapper.readValue(inputJSON, User.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(inputUser != null) {
			return new ResponseEntity<Boolean>(this.ctrlService
													.authenticate(inputUser.getUsername(),
														  inputUser.getUserpassword()), 
													HttpStatus.OK
										   		);
		} else return new ResponseEntity<Boolean>(new Boolean(false), HttpStatus.OK);
	}
}
