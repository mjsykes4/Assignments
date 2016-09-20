package ssa;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Students extends HashMap {

	public static Connection myConn=null;
	public static PreparedStatement myStmt=null;
	public static ResultSet myRs=null;
	int id;
	String firstName;
	String lastName;
	int sat;
	double gpa;
	
	
	private ArrayList<Student> getInfo(String sql) throws SQLException {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try{ 
			myConn=Database.makeConnection();
			myStmt= myConn.prepareStatement("select * from student");
			myRs=myStmt.executeQuery();
			while (myRs.next()) {
			Student student = new Student();
			student.setId(myRs.getInt("id"));
			student.setFirstName(myRs.getString("first_name"));
			student.setLastName(myRs.getString("last_name"));
			student.setSat(myRs.getInt("sat"));
			student.setGpa(myRs.getDouble("gpa"));
			students.add(student);
	}
			return students;
			

			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			Database.close();
			}
		
		return null;
}
		
	public Student getById(int i) throws SQLException {
		List<Student> students = getInfo("SELECT * from student where id = " + i);
		return students.get(0);
		
	}
	

	public ArrayList<Student> getAll() throws SQLException {
		return getInfo("SELECT * from student");
		}

	
	}

