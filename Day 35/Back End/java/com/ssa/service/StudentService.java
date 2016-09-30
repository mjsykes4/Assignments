package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.dao.IStudentDAO;
import com.ssa.entity.Student;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentDAO studentDAO;

	@Override
	public List<Student> getAllStudents() {

		return studentDAO.getAllStudents();
	}

	@Override
	public Student getStudentById(int studentID) {

		return studentDAO.getStudentById(studentID);
	}

	@Override
	public boolean addStudent(Student student) {

		return studentDAO.addStudent(student);
	}

	@Override
	public void updateStudent(Student student){ 
		
		return;
	}

	@Override
	public void deleteStudent(int studentId) {
		studentDAO.deleteStudent(studentId);
		
	}

	public IStudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
}
