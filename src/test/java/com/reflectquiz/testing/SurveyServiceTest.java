package com.reflectquiz.testing;

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

import com.reflectquiz.model.Survey;
import com.reflectquiz.repository.SurveyRepositoryImpl;
import com.reflectquiz.service.SurveyService;


@TestInstance(Lifecycle.PER_CLASS)
public class SurveyServiceTest {
	@Mock
	private SurveyRepositoryImpl dummy = new SurveyRepositoryImpl();
	
	@InjectMocks
	private SurveyService testService;
	
	Survey second;
	
	@BeforeAll
	void setUp() {
		testService = new SurveyService(dummy);
		MockitoAnnotations.initMocks(this);
		List<Survey> dummyList = new ArrayList<Survey>();
		Survey first = new Survey(1, 1, 1, "It was too long");
		second = new Survey(1, 1, 2, "It was too short");
		Survey third = new Survey(2, 2, 1, "It was too long");
		Survey fourth = new Survey(2, 2, 2, "It was too short");
		Survey fifth = new Survey(3, 3, 3, "It was just right");
		dummyList.add(first);
		dummyList.add(second);
		dummyList.add(third);
		dummyList.add(fourth);
		dummyList.add(fifth);
		when(dummy.getAllSurveys()).thenReturn(dummyList);
		when(dummy.getSurveyById(1)).thenReturn(first);
		when(dummy.getSurveyById(2)).thenReturn(second);
		when(dummy.getSurveyById(3)).thenReturn(third);
		when(dummy.getSurveyById(4)).thenReturn(fourth);
		when(dummy.getSurveyById(5)).thenReturn(fifth);
	}
	
	@Test
	void testGetAllSurveys() {
		Assertions.assertEquals("It was too long", testService.getAllSurveys().get(0).getSurveyInputField());
		Assertions.assertEquals("It was too short", testService.getAllSurveys().get(1).getSurveyInputField());
		Assertions.assertEquals("It was too long", testService.getAllSurveys().get(2).getSurveyInputField());
		Assertions.assertEquals("It was too short", testService.getAllSurveys().get(3).getSurveyInputField());
		Assertions.assertEquals("It was just right", testService.getAllSurveys().get(4).getSurveyInputField());
	}
	
	@Test
	void testGetSurveyById() {
		Assertions.assertEquals("It was too long", testService.getSurveyById(3).getSurveyInputField());
	}

//TODO: add InsertSurvey and UpdateSurvey test without accessing real database.
//	@Test
//	void testInsertSurvey() {
//		Survey sixth = new Survey(2, 1, 3, "here's a survey for ya!");
//		testService.insertSurvey(sixth);
//		Assertions.assertEquals("here's a survey for ya!", testService.getSurveyById(6).getSurveyInputField());
//	}
//
//	@Test
//	void testUpdateSurvey() {
//		Assertions.assertEquals("It was too long", testService.getSurveyById(3).getSurveyInputField());
//		second.setSurveyInputField("Updated");
//		testService.updateSurvey(second);
//		Assertions.assertEquals("Updated", testService.getSurveyById(3).getSurveyInputField());
//	}
}
