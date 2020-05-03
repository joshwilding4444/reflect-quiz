package com.reflectquiz.testing;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.reflectquiz.model.User;
import com.reflectquiz.repository.UserDataRepository;
import com.reflectquiz.repository.UserDataRepositoryImpl;

@TestInstance(Lifecycle.PER_CLASS)
class UserTest {
	
	UserDataRepository userDAO;
	
	@BeforeAll
	void setUp() {
		userDAO = new UserDataRepositoryImpl();
	}
	
	@Test
	void testGetUser() {
		User testUser = userDAO.getUserByUsername("u1");
		Assertions.assertEquals("u1", testUser.getUsername());
	}
	
	@Test
	void testGetAllUsers() {
		List<User> lotsOfUsers = userDAO.getAllUsers();
		Assertions.assertEquals("u1", lotsOfUsers.get(0).getUsername());
	}
	
	@Test
	void testInsertUser() {
		userDAO.insertUser(new User(0, "billcipher", "triangle", "TEACHER"));
	}

}
