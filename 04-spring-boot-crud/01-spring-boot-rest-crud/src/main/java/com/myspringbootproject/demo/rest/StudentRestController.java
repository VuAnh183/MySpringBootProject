package com.myspringbootproject.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringbootproject.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	
	private List<Student> studentList;
	
	// define @PostConstruct to load the student data only once
	@PostConstruct
	public void loadData() {
		
		studentList = new ArrayList<>();
		
		studentList.add(new Student("Vu Anh", "Dinh"));
		studentList.add(new Student("Ngoc Lam", "Pham"));
		studentList.add(new Student("Minh Tuan", "Nguyen"));
		
	}
	
	
	// define endpoint for "/students" - return a list of student
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return studentList;
	}
	

	// define endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// just index into the list ... keep it simple for now
		
		
		// check the studentId again list size
		
		if ((studentId >= studentList.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return studentList.get(studentId); 
	}
	
	
	// Add an exception handler using @ExceptionHandler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		// create a StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	
	// Add another exception handler ... to catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		// create a StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
