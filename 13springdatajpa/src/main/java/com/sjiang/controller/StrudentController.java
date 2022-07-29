package com.sjiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sjiang.model.Student;
import com.sjiang.repository.StudentRepository;


@RestController
public class StrudentController {
	
	@Autowired
	private StudentRepository repository;
	
	@RequestMapping(value="/students", method=RequestMethod.POST)
	public Student insertStudent(@RequestBody Student student) {
		repository.save(student);
		
		return student;
	}
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> viewAll(){
		return repository.findAll();
	}

}
