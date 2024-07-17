package com.myspringproject.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myspringproject.cruddemo.dao.StudentDAO;
import com.myspringproject.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner ->{
//			createStudent(studentDAO);
			
			createMultiple(studentDAO);
			
//			readStudent(studentDAO);
			
//			queryForStudent(studentDAO);
			
//			queryForStudentByLastName(studentDAO);
			
//			updateStudent(studentDAO);
			
//			deleteStudent(studentDAO);
			
//			deleteAll(studentDAO);
		};
	}

	
	private void deleteAll(StudentDAO studentDAO) {
		// delete all student
		System.out.println("Delete all student...");
		int numRowsDeleted = studentDAO.deleteAll();
		
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// delete the student
		int studentId = 1;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Delete success!");
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		// change first name to "Vu Anh"
		System.out.println("Updating student...");
		myStudent.setFirstName("Ngoc Lam");
		
		// update the student
		studentDAO.update(myStudent);
		
		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		
		// get a list of students 
		List<Student> theStudents = studentDAO.findByLastName("Dinh");
		
		
		// display list of student
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		
		
	}

	private void queryForStudent(StudentDAO studentDAO) {
		
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		
		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Vu Anh", "Dinh", "dinhvuanh2708@gmail.com");
		
		
		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		
		// display id of the saved student
		int theID = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theID);
		
		
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theID);
		Student myStudent = studentDAO.findById(theID);
		
		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultiple(StudentDAO studentDAO) {
		// create multiple students
		
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Lam", "Pham", "lam@gmail.com"); 
		Student tempStudent2 = new Student("Tuan", "Nguyen", "tuan@gmail.com");
		Student tempStudent3 = new Student("Nhi", "Tran", "linhnhitn183@gmail.com");
		
		// save the student objects
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Vu Anh", "Dinh", "dinhvuanh2708@gmail.com");
		
		
		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
