package com.reflectquiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("ReflectQuizController")
@RequestMapping(path = "/reflect-quiz")
public class ReflectQuizController {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "index";
	}
}
