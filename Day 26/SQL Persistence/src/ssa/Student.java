package ssa;

public class Student {

	int id;
	String firstName;
	String lastName;
	int sat;
	double gpa;
	@Override
	public String toString() {
		String msg = String.format("%3d %-20s %4.2f %4d",
				this.id,
				this.firstName + " " + this.lastName,
				this.gpa,
				this.sat);
		return msg;
	}
	// private project constructor - call Students.createInstance()
	Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSat() {
		return sat;
	}
	public void setSat(int sat) {
		this.sat = sat;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
}

