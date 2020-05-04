package com.reflectquiz.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;
import com.reflectquiz.controller.UserController;
import com.reflectquiz.model.User;
import com.reflectquiz.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestInstance(Lifecycle.PER_CLASS)
class UserControllerTest {

	@Mock
	private UserService dummy = new UserService();
	
	@InjectMocks
	private UserController testController;
	
	@BeforeAll
	public void setUp() {
		testController = new UserController(dummy);
		MockitoAnnotations.initMocks(this);
		List<User> dummyList = new ArrayList<User>();
		User first = new User(1, "Stanley", "password", "TEACHER");
		User second = new User(2, "Soos", "password", "TEACHER");
		User third = new User(3, "Dipper", "password", "STUDENT");
		User fourth = new User(4, "Maybel", "password", "STUDENT");
		User fifth = new User(5, "Candy", "password", "STUDENT");
		dummyList.add(first);
		dummyList.add(second);
		dummyList.add(third);
		dummyList.add(fourth);
		dummyList.add(fifth);
		when(dummy.getAllUsers()).thenReturn(dummyList);
		when(dummy.getUserByUsername("Stanley")).thenReturn(first);
		when(dummy.getUserByUsername("Soos")).thenReturn(second);
		when(dummy.getUserByUsername("Dipper")).thenReturn(third);
		when(dummy.getUserByUsername("Maybel")).thenReturn(fourth);
		when(dummy.getUserByUsername("Candy")).thenReturn(fifth);
		when(dummy.authenticate("Stanley", "password")).thenReturn(true);
		when(dummy.authenticate("Soos", "password")).thenReturn(true);
		when(dummy.authenticate("Dipper", "password")).thenReturn(true);
		when(dummy.authenticate("Maybel", "password")).thenReturn(true);
		when(dummy.authenticate("Candy", "password")).thenReturn(true);
	}
	
	@Test
	public void testGetUserByUsername() {
	    ResponseEntity<User> resultUser = testController.getUserByUsername("Dipper");
	    Assertions.assertEquals(200, resultUser.getStatusCodeValue());
	    Assertions.assertEquals("Dipper", resultUser.getBody().getUsername());
	}
	
	@Test
	public void testGetAllUsers() {
		ResponseEntity<List<User>> listOfUsers = testController.getAllUsers();
		Assertions.assertEquals(200, listOfUsers.getStatusCodeValue());
		Assertions.assertEquals("Stanley", listOfUsers.getBody().get(0).getUsername());
		Assertions.assertEquals("Soos", listOfUsers.getBody().get(1).getUsername());
		Assertions.assertEquals("Dipper", listOfUsers.getBody().get(2).getUsername());
		Assertions.assertEquals("Maybel", listOfUsers.getBody().get(3).getUsername());
		Assertions.assertEquals("Candy", listOfUsers.getBody().get(4).getUsername());
	}
	
	@Test
	public void testAuthenticate() {
		ResponseEntity<Boolean> authResult = testController.authenticate("Maybel", 
																		 "password");
		Assertions.assertTrue(authResult.getBody());
	}

}
