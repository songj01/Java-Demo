package com.sjiang2020.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjiang2020.model.Student;

@Repository
public interface StudentRespository extends JpaRepository<Student, Integer>{

}
