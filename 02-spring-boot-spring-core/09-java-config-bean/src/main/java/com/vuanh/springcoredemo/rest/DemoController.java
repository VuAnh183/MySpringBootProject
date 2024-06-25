package com.vuanh.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuanh.springcoredemo.common.Coach;

@RestController
public class DemoController {

	// define a private field for the dependency
	private Coach myCoach;
	
	
	@Autowired
	public DemoController(
			@Qualifier("swim") Coach theCoach) {
		System.out.println("In constructor: " + getClass().getSimpleName());
		myCoach = theCoach;
	}
	
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	
}
