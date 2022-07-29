package com.sjiang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjiang.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
