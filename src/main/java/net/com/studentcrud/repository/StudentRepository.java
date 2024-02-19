package net.com.studentcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.com.studentcrud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
//    @Query("INSERT INTO Student (studentName, studentAge, studentAddress) VALUES (:studentName, :studentAge, :studentAddress)")
//	 Student createStudent(String studentName,int studentAge,String studentAddress);

	//find the age of student
//     @Query("SELECT s FROM Student s WHERE s.studentAge = 25")
//     List<Student> getAllAges(int studentAge);
//     
     @Query("SELECT k FROM Student k WHERE k.studentAge BETWEEN :minAge AND :maxAge")
     List<Student> getAllAges(int minAge, int maxAge);
     //List<Student> getAllAges(int maxAge);
}
