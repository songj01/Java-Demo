package com.sjiang2020.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjiang2020.model.Student;
import com.sjiang2020.repository.StudentRespository;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRespository studentRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findById(Integer id) {
		// TODO Auto-generated method stub
		 
			return  studentRepository.findById(id);
				
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

}
