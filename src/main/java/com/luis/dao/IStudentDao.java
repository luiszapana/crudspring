package com.luis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.model.Student;

public interface IStudentDao extends JpaRepository<Student, Long>{

}
