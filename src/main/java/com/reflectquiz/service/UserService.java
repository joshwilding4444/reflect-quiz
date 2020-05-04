package com.reflectquiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reflectquiz.model.User;
import com.reflectquiz.repository.UserDataRepositoryImpl;

@Service("UserService")
public class UserService {
	@Autowired
	private UserDataRepositoryImpl userRepository;
	
	public UserService(UserDataRepositoryImpl userRepository) {
		this.userRepository = userRepository;
	}

	public UserService() {
	}

	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
	
	public void insertUser(User inputUser) {
		userRepository.insertUser(inputUser);
	}

	public void setUserRepository(UserDataRepositoryImpl userRepository) {
		this.userRepository = userRepository;
	}
	
	/**
	 * Authenticates with the backend
	 * @param username: input username given by user
	 * @param password: input password given by user
	 * @return authenticated: true if the parameters match the database 
	 * 						  username and password or false otherwise
	 * */
	public boolean authenticate(String username, String password) {
		boolean authenticated = false;
		if(password.equals(this.getUserByUsername(username).getUserpassword())) {
			authenticated = true;
		}
		return authenticated;
	}
	
}

