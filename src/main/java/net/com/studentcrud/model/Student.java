package net.com.studentcrud.model;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String studentName;
	private int studentAge;
	private String studentAddress;
	
	public Student() {
		super();
	}

	public Student(String studentName, int studentAge, String studentAddress) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentAddress = studentAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
//
//	public Object thenReturn(Optional<Student> of) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	

}
