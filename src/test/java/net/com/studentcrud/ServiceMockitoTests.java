package net.com.studentcrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;
import net.com.studentcrud.controller.StudentController;
import net.com.studentcrud.model.Student;
import net.com.studentcrud.repository.StudentRepository;
import net.com.studentcrud.service.StudentService;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {ServiceMockitoTests.class})
public class ServiceMockitoTests {

	@Mock
	public StudentRepository studentRepository;
	
	@InjectMocks
	public StudentService studentService;
	
	@InjectMocks
	public StudentController studentController;
	
	public List<Student>myStudents;
	
	@Test
	@Order(1)
	public void test_getStudent()
	{
		List<Student> myStudents = new ArrayList<Student>();
		myStudents.add(new Student("Soham",25,"Mumbai"));
		myStudents.add(new Student("Akshay",23,"Nanded"));

		when(studentRepository.findAll()).thenReturn(myStudents);//mocking
		assertEquals(2,studentService.getStudent().size());
		//assertThrows(, null);
	}
//-------------------------------------------------------------------------------------------------	

//	@Test
//	@Order(2)
//	public void test_getStudentById() {
//	    // Create sample students
//	    Student student1 = new Student("Soham", 25, "Mumbai");
//	    Student student2 = new Student("Akshay", 23, "Nanded");
//	    
//	    // Mock the findById method of the studentRepository
//	    when(studentRepository.findById(1)).thenReturn(Optional.of(student1));
//	    when(studentRepository.findById(2)).thenReturn(Optional.of(student2));
//	    
//	    // Call the getStudentById method and assert the results
//	    assertEquals(student1, studentService.getStudentById(1));
//	    assertEquals(student2, studentService.getStudentById(2));
//	}

//-------------------------------------------------------------------------------------------------	
	@Test
	@Order(2)
	public void test_getStudentById() {
	    
	    Student testStudent = new Student("Soham", 25, "Mumbai");// Create a sample student
	    
	    
	    when(studentRepository.findById(1)).thenReturn(Optional.of(testStudent));// Mock the findById method of the studentRepository
	    
	    
	    assertEquals(testStudent, studentService.getStudentById(1));// Call the getStudentById method and assert the result
	}
//-------------------------------------------------------------------------------------------------	
	
	@Test
	@Order(3)
	public void test_createStudent()
	{
	Student student = new Student("Rohan", 26, "Dubai");
	
	when (studentRepository.save(student)).thenReturn(student);
	assertEquals(student,studentService.createStudent(student));
	}
	
//	@Test
//	@Order(4)
//	public void test_updateStudent() {
//	    
//	    Student testStudent = new Student("Raj", 25, "Delhi");// Create a sample student
//	    
//	    
//	    when(studentRepository.save(testStudent)).thenReturn(testStudent);// Mock the findById method of the studentRepository
//	    
//	    
//	    assertEquals(testStudent, studentService.updateStudent(testStudent));// Call the getStudentById method and assert the result
//	}
//
//	@Test
//	@Order(4)
//	public void test_updateStudent()
//	{
//		Student student = new Student("Atharv",22,"Nerul");
//		
//		when( studentService.updateStudent(student,1)).thenReturn(student);
//		Student updatedStudent =studentController.updateStudent(1, student);
//		verify(studentService,times(1)).updateStudent(updatedStudent, 1);
//		
//		when(studentRepository.save(updatedStudent)).thenReturn(updatedStudent);
//		assertEquals("Atharv",updatedStudent.getStudentName());
//		assertEquals(22,updatedStudent.getStudentAge());
//		assertEquals("Nerul",updatedStudent.getStudentAddress());
	//}
	
	@Test
	@Order(4)
	public void test_updateStudent() {
	    // Given
	    Student student = new Student("Atharv", 22, "Nerul");
	    studentRepository.save(student);

	    // Mock the updateStudent method of studentService
	    when(studentService.updateStudent(student, 1)).thenReturn(student);

	    // When
	    Student updatedStudent = studentController.updateStudent(1, student);

	    // Then
	    // Verify that updateStudent method of studentService was called with the correct arguments
	    verify(studentService, times(1)).updateStudent(student, 1);

	    // Mock the save method of studentRepository
	    when(studentRepository.save(updatedStudent)).thenReturn(updatedStudent);

	    // Assertions
	    assertEquals("Atharv", updatedStudent.getStudentName());
	    assertEquals(22, updatedStudent.getStudentAge());
	    assertEquals("Nerul", updatedStudent.getStudentAddress());
	}

	

	@Test
	@Order(5)
 public void test_deleteStudent()
 {
	 Student student = new Student("Atharv",22,"Nerul");
	 studentService.deleteStudent1(student);
	 verify(studentRepository,times(1)).delete(student);
	 
 }

	
}
