package ssa;

import java.sql.SQLException;
import java.util.ArrayList;

public class Mainline {

	public static void main(String[] args) throws SQLException {
		 
		
		Students students = new Students();
		    Student aStudent = students.getById(170);
		    System.out.println(aStudent); 
		    
		    ArrayList<Student> allStudents = students.getAll();
		    for(Student student : allStudents) {
		        System.out.println(student);
		    }

	}

}
