package ssa;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database {
	
	public static Connection myConn=null;
	public static PreparedStatement myStmt=null;
	public static ResultSet myRs=null;
	
	public static Connection makeConnection() throws FileNotFoundException, IOException, SQLException {
		Properties prop= new Properties();
		prop.load(new FileInputStream("demo.properties"));
		String theUser = prop.getProperty("user");
		String thePassword = prop.getProperty("password");
		String theDburl = prop.getProperty("url");
		myConn= DriverManager.getConnection(theDburl, theUser, thePassword);
		return myConn;
	}
	public static void close() throws SQLException{
		if(myConn!=null)
			myConn.close();
		if(myStmt!= null)
			myStmt.close();
	}

}
