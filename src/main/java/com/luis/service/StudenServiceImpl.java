package com.luis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luis.dao.IStudentDao;
import com.luis.model.Student;
@Service
public class StudenServiceImpl implements IStudentService{

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public List<Student> getAll() {
		return studentDao.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentDao.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentDao.deleteById(id);
	}
}
