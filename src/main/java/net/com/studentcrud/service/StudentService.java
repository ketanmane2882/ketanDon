package net.com.studentcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import net.com.studentcrud.model.Student;
import net.com.studentcrud.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepository;
	
	//-------------------------------------------------------------------------------------------------------------
	//Create A Student
	public Student createStudent(Student student) {
		
		return  studentRepository.save(student);
	}
	
	//-------------------------------------------------------------------------------------------------------------

	//Get Students
	public List<Student> getStudent()
	{	
		List<Student> students =new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	//get Specifc Student
	public Student getStudentById(int studentId)
	{
		return studentRepository.findById(studentId).orElseThrow();
	}
	//-------------------------------------------------------------------------------------------------------------
  
	public Student updateStudent(Student student ,int studentId)
	{
		Student std = studentRepository.findById(studentId).orElseThrow();
		std.setStudentName(student.getStudentName());
		std.setStudentAge(student.getStudentAge());
		std.setStudentAddress(student.getStudentAddress());
		 return studentRepository.save(std);
	}
	//-------------------------------------------------------------------------------------------------------------

	public void deleteStudent(int studentId)
	{
		studentRepository.deleteById(studentId);
	}
	public void deleteStudent1(Student student)
	{
		studentRepository.delete(student);
	}
	
//	public void deleteStudent(int studentId) throws Exception
//	{
//		if(studentRepository.existsById(studentId))
//		{
//			studentRepository.deleteById(studentId);
//		}
//		else
//		{
//			throw Exception ("User can't Deleted");
//		}
	
}
