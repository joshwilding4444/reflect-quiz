package com.reflectquiz.testing;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

import com.reflectquiz.model.User;
import com.reflectquiz.repository.UserDataRepository;
import com.reflectquiz.repository.UserDataRepositoryImpl;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserTest {
	
	UserDataRepository userDAO;
	
	@BeforeAll
	public void setUp() {
		userDAO = new UserDataRepositoryImpl();
	}
	
	public void testGetUser() {
		User testUser = userDAO.getUserByUsername("u1");
		testUser.getUsername();
		Assertions.assertEquals("u1", testUser.getUsername());
	}
	
	
	public void testGetAllUsers() {
		List<User> lotsOfUsers = userDAO.getAllUsers();
		Assertions.assertEquals("u1", lotsOfUsers.get(0).getUsername());
	}
	
	public void testInsertUser() {
		userDAO.insertUser(new User(0, "billcipher", "triangle", "TEACHER"));
	}

}
