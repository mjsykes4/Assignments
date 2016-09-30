package com.ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssa.entity.Student;
import com.ssa.service.IStudentService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        Student students = studentService.getStudentById(id);
        return new ResponseEntity<Student>(students, HttpStatus.OK);
    }
	
	@RequestMapping(value="/student", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }
}
