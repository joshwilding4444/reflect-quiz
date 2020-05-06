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

import com.reflectquiz.model.User;
import com.reflectquiz.repository.UserDataRepositoryImpl;
import com.reflectquiz.service.UserService;


@TestInstance(Lifecycle.PER_CLASS)
class UserServiceTest {

	@Mock
	private UserDataRepositoryImpl dummy = new UserDataRepositoryImpl();
	
	@InjectMocks
	private UserService testService;
	
	@BeforeAll
	void setUp() {
		testService = new UserService(dummy);
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
		
	}
	
	@Test
	void testGetAllUsers() {
		Assertions.assertEquals("Stanley", testService.getAllUsers().get(0).getUsername());
		Assertions.assertEquals("Soos", testService.getAllUsers().get(1).getUsername());
		Assertions.assertEquals("Dipper", testService.getAllUsers().get(2).getUsername());
		Assertions.assertEquals("Maybel", testService.getAllUsers().get(3).getUsername());
		Assertions.assertEquals("Candy", testService.getAllUsers().get(4).getUsername());
	}
	
	@Test
	void testGetUserByUsername() {
		Assertions.assertEquals("Maybel", testService.getUserByUsername("Maybel").getUsername());
	}
	
	@Test
	void testAuthenticate() {
		Assertions.assertTrue(testService.authenticate("Candy", "password"));
		Assertions.assertFalse(testService.authenticate("Soos", "dskfsljlkjf"));
	}
	
	@Test
	void testBadUsername() {
		Assertions.assertFalse(testService.authenticate("sfhgljglh", "password"));
	}

}
