package ssa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class EducationDB {
	
	public static Connection myConn=null;
	public static PreparedStatement myStmt=null;
	public static ResultSet myRs=null;

	public static void main(String[] args) throws SQLException {
		
	enrollStudent();
		
	}
	public static void display() throws SQLException{
		while (myRs.next()){
			String fName= myRs.getString("first_name");
			String lName= myRs.getString("last_name");
			String major = myRs.getString("description");
			String subject= myRs.getString("subject");
			
			System.out.println("Education System- Enrollment Process");
			System.out.println("====================================");

		}
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
	public static void enrollStudent() throws SQLException{
		
		try{
			makeConnection();
			//2. Create Statement
			myStmt= myConn.prepareStatement("insert into student(first_name,last_name,sat,gpa) values (?,?,?,?)");
			//3. Execute SQL
			myStmt.setString(1,"Muhammad");
			myStmt.setString(2,"Ali");
			myStmt.setInt(3, 1600);
			myStmt.setDouble(4,4.0);
			myStmt.executeUpdate();
			
			System.out.println("++++++++++++++++++++++++++++++");
			System.out.println("First Result Set");
			System.out.println("++++++++++++++++++++++++++++++");
			display();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			close();
			}
	}
private static void updateData() throws SQLException{
		
		try{
			makeConnection();
			myStmt= myConn.prepareStatement("update student set major= 'General Business', where last_name='Ali'");
			myStmt.setString(1,"General Business");
			myStmt.executeUpdate();
			
			display();
		}catch(Exception ex){
			
		}finally{
			close();
			}
	}
}
