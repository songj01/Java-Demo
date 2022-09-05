package com.sjiang2020.service;

import java.util.List;
import java.util.Optional;

import com.sjiang2020.model.Student;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Optional<Student> findById(Integer id);
	public Student addStudent(Student student);

}
