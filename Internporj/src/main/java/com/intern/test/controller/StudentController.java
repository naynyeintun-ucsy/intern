package com.intern.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intern.test.entity.Student;
import com.intern.test.pojo.StudentPojo;
import com.intern.test.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	//Test
	@GetMapping (value = "/student")
	public List<Student> getStudent() {
		return studentService.getStudent();
	}
	
	@PostMapping (value = "/student")
	public Student addStudent(@RequestBody Student student)
	{
       return studentService.save(student);
	}
	
	@GetMapping (value = "/student/{id}")
	public Student getById(@PathVariable Long id)
	{
		return studentService.findById(id);
	}
	
	@DeleteMapping (value = "/student/{id}")
	public void deleteById(@PathVariable Long id)
	{
		studentService.deleteStudent(id);
	}
	
	@PutMapping (value = "/student")
	public Student updateStudent(@RequestBody StudentPojo studentPojo) {
		
		Student student = studentService.findById(studentPojo.getId());
		if(student==null) {
			return null;
		}
		student.setPhone(studentPojo.getPhone());
		student.setRollNo(studentPojo.getRollNo());
		return studentService.save(student);
		
	}
	
	
	
	

}
