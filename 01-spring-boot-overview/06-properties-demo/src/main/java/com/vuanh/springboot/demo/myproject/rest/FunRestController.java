package com.vuanh.springboot.demo.myproject.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	// expose a new endpoint for "workout"
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	// expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Lucky day!";
	}
	
	// inject properties from: my.name and department.name
	@Value("${my.name}")
	private String myName;
	
	@Value("${department.name}")
	private String departmentName;
	
	// expose new endpoint for "studentinfo"
	
	@GetMapping("/studentinfo")
	public String getStudentInfo() {
		return "Name: " + myName + " Dept: " + departmentName; 
		
	}
	
}