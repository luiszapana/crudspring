package com.luis.service;

import java.util.List;
import com.luis.model.Student;

public interface IStudentService {
	List<Student> getAll();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudent(Long id);
}
