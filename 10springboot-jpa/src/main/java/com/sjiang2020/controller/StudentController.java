package com.sjiang2020.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjiang2020.model.Student;
import com.sjiang2020.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("students/{id}")
	public Student addStudent(@PathVariable Integer id, @RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/students/all")
	public List<Student> findAll(){
		return studentService.findAll();
	}
	

}
