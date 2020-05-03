package com.reflectquiz.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.reflectquiz.model.User;
import com.reflectquiz.repository.UserDataRepositoryImpl;

class UserTest {
	
	UserDataRepositoryImpl userDAO;
	
	@BeforeEach
	void setUp() {
		userDAO = new UserDataRepositoryImpl();
	}
	/*
	 * The following are dummy values. The first two tests assume these
	 * values already exist in the database.
	 * */
	@Test
	void testGetUser() {
		User testUser = userDAO.getUserById(6);
		Assertions.assertEquals("mabelpinesrainbow", testUser.getUsername());
	}
	
	@Test
	void testGetAllUsers() {
		List<User> lotsOfUsers = userDAO.getAllUsers();
		Assertions.assertEquals("dipperpines", lotsOfUsers.get(1).getUsername());
	}
	
	@Test
	void testInsertUser() {
		userDAO.insertUser(new User(0, "billcipher", "triangle", "TEACHER"));
	}

}
