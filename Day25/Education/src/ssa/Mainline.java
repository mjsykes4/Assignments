package ssa;

import java.sql.SQLException;

public class Mainline extends Student {

	public static void main(String[] args) throws SQLException {
		

			Students newStudent = new Students();
			newStudent.add(new Student("Adam","Zapel",1200,3.0, "Finance"));
			newStudent.add(new Student("Graham","Krakir",500,2.5,"General Studies"));
			newStudent.add(new Student("Ella","Vader",800,3.0, "Accouting"));
			newStudent.add(new Student("Stanley","Kupp",1350,3.3, "Engineering"));
			newStudent.add(new Student("Lou","Zar",950,3.0,"Education"));
			
			setMajor("Finance", 170);
			addClasses(170,10101);
			addClasses(170,20202);
		}
	}

