package com.reflectquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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
	@PostMapping(path = "/{name}/authenticate", 
							produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Boolean> authenticate(@PathVariable String name, 
												  String password) {
		//Either this method should send a redirect, or the frontend should 
		//have an appropriate response if authentication fails.
		return new ResponseEntity<Boolean>(this.ctrlService.authenticate(name, password), 
										   HttpStatus.OK
										   );
	}
}
