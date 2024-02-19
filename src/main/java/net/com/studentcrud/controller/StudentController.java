package net.com.studentcrud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.com.studentcrud.model.Student;
import net.com.studentcrud.repository.StudentRepository;
import net.com.studentcrud.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	public StudentRepository studentRepository;
	

//-------------------------------------------------------------------------------------------------------------
	@Autowired
	public StudentService studentService;
//-------------------------------------------------------------------------------------------------------------

	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student ) 
	{
		return studentService.createStudent(student);
	}
//-------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/getStudent")
	public List<Student> getStudent()
	{
		return studentService.getStudent();
	}
//-------------------------------------------------------------------------------------------------------------
	@GetMapping("/getStudent/{studentId}")
	public Student getStudentById(@PathVariable int studentId)
	{
		return studentService.getStudentById(studentId);
	}
//-------------------------------------------------------------------------------------------------------------
    @PutMapping("/updateStudent/{studentId}")
	public Student updateStudent(@PathVariable int studentId ,@RequestBody Student student)
    {
    	return studentService.updateStudent(student, studentId) ;
    }
  //-------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable int studentId)
    {
    	 studentService.deleteStudent(studentId);
    	 return "Deletion Succesful";
    }
    
    //-------------------------------------------------------------------------------------------------------------

	@GetMapping("/getAllAges/{maxAge}/{minAge}")
    List<Student>getAllAges(@PathVariable int maxAge, @PathVariable int minAge)
    {
    	return studentRepository.getAllAges(maxAge,minAge);
    }
    //-------------------------------------------------------------------------------------------------------------

	 @DeleteMapping("/deleteStudent")
	public void deleteStudent1(@RequestBody Student student)
	{
		studentService.deleteStudent1(student);
	}
	
	
	
	
	
	
	
	
	
	
//	
//	public StudentController(StudentRepository studentRepository)
//	{
//		this.studentRepository = studentRepository;
//	}
	
//@PostMapping("/create/{studentName}/{studentAge}/{studentAddress}")
// public Student createStudentDetails(@RequestBody Student student,@PathVariable String studentName,@PathVariable int studentAge , @PathVariable String studentAddress)
// {
//	 return studentRepository.createStudent(studentName,studentAge,studentAddress);
// }

//	public Student createStudent(@RequestBody Student student)
//	{
//		return null;
//	}

}
