package com.myspringproject.cruddemo.dao;

import java.util.List;

import com.myspringproject.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
}