package ssa;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Student {

	public static Connection myConn=null;
	public static PreparedStatement myStmt=null;
	public static ResultSet myRs=null;
	int id = 0;
	String firstName = null;
	String lastName = null;
	int sat = 0;
	double gpa = 0;
	String newMajor = null;
	int majorId= 0;
	public static int aMajor;
	
	public Student(){};
	
	public Student(String firstName, String lastName, int sat, double gpa, String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sat = sat;
		this.gpa = gpa;
		this.newMajor = newMajor;
	}

	private static void makeConnection() throws FileNotFoundException, IOException, SQLException {
		Properties prop= new Properties();
		prop.load(new FileInputStream("demo.properties"));
		String theUser = prop.getProperty("user");
		String thePassword = prop.getProperty("password");
		String theDburl = prop.getProperty("url");
		myConn= DriverManager.getConnection(theDburl, theUser, thePassword);
}
	private static void close() throws SQLException{
		if(myConn!=null)
			myConn.close();
		if(myStmt!= null)
			myStmt.close();
	}
	
public void enrollStudent() throws SQLException{
		
		try{ 
			makeConnection();
			myStmt= myConn.prepareStatement("insert into student (first_name,last_name,sat,gpa) values (?,?,?,?)");
			myStmt.setString(1,this.firstName);
			myStmt.setString(2,this.lastName);
			myStmt.setInt(3, this.sat);
			myStmt.setDouble(4,this.gpa);
			myStmt.executeUpdate();
			myStmt=myConn.prepareStatement("select last_insert_id()");
			myRs= myStmt.executeQuery();
			myRs.next();
			this.id=myRs.getInt(1);
			
			System.out.println("Why won't they add?");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			close();
			}
	}
//public void setMajor(String newMajor) throws SQLException{
	public static void setMajor(String newMajor, int studentId) throws SQLException{
	try{ 
		makeConnection();
		myStmt= myConn.prepareStatement("select * from major where description = ?");
		myStmt.setString(1,newMajor);
		myRs= myStmt.executeQuery();
		while (myRs.next()){
			aMajor= myRs.getInt("id");
		
		myStmt= myConn.prepareStatement("update student set major_id = ? where id= ?");
		myStmt.setInt(1,aMajor);
		myStmt.setInt(2,studentId);
		myStmt.executeUpdate();
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}finally{
		close();
	}
	}
public static void addClasses(int id, int classId) throws SQLException{
	
	try{
		makeConnection();
		myStmt= myConn.prepareStatement("insert student_class_relationship (student_id, class_id) values (?,?)");
		myStmt.setInt(1, id);
		myStmt.setInt(2, classId);
		myStmt.executeUpdate();
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		close();
	}	
}
}