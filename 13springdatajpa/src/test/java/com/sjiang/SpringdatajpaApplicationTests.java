package com.sjiang;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sjiang.model.Student;
import com.sjiang.repository.StudentRepository;

@SpringBootTest
public class SpringdatajpaApplicationTests {
	
	@Autowired
	private StudentRepository repository;
	@Test
	public void testCreateStudent() {
		Student student = new Student(); 
		 student.setId(1); 
		 student.setName("Nanda"); 
		 student.setScore(99); 
		 
		 repository.save(student); 
		 
		 Student savedStudent = repository.findById(1).get(); 
		 assertNotNull(savedStudent); 
		
	}
	

}
