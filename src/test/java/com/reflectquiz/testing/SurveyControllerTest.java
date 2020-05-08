package com.reflectquiz.testing;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.reflectquiz.controller.SurveyController;
import com.reflectquiz.model.Survey;
import com.reflectquiz.repository.SurveyRepositoryImpl;
import com.reflectquiz.service.SurveyService;


import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(locations = "classpath:testContext.xml")
@WebAppConfiguration

@TestInstance(Lifecycle.PER_CLASS)
public class SurveyControllerTest {

	SurveyRepositoryImpl surveyRepositoryImpl = new SurveyRepositoryImpl();
	
	@Mock
	private SurveyService dummy = new SurveyService(surveyRepositoryImpl);
	
	@InjectMocks
	private SurveyController testController;
	
	private MockMvc mockMVC;
	
	@BeforeAll
	public void setUp() {
		testController = new SurveyController(dummy);
		MockitoAnnotations.initMocks(this);
		mockMVC = MockMvcBuilders.standaloneSetup(testController).build();
		List<Survey> dummyList = new ArrayList<Survey>();
		Survey first = new Survey(1, 1, 1, "It was too long");
		Survey second = new Survey(1, 1, 2, "It was too short");
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
	public void testGetSurveyById() {
	    Survey resultSurvey = dummy.getSurveyById(1);
	    Assertions.assertEquals("It was too long", resultSurvey.getSurveyInputField());
	}
	
	@Test
	public void testGetAllSurveys() {
		ResponseEntity<List<Survey>> listOfSurveys = testController.getAllSurveys();
		Assertions.assertEquals(200, listOfSurveys.getStatusCodeValue());
		Assertions.assertEquals("It was too long", listOfSurveys.getBody().get(0).getSurveyInputField());
		Assertions.assertEquals("It was too short", listOfSurveys.getBody().get(1).getSurveyInputField());
		Assertions.assertEquals("It was too long", listOfSurveys.getBody().get(2).getSurveyInputField());
		Assertions.assertEquals("It was too short", listOfSurveys.getBody().get(3).getSurveyInputField());
		Assertions.assertEquals("It was just right", listOfSurveys.getBody().get(4).getSurveyInputField());
	}
	
	@Test
	public void testGetAllAtController() {
		try {
			mockMVC.perform(get("/Survey/alls")).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print()).andReturn();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetOneSurveyAtController() {
		try {
			mockMVC.perform(get("/Survey/id/1")).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print()).andReturn();
		} catch(Exception e) {
			e.printStackTrace();
		}			
	}
}
