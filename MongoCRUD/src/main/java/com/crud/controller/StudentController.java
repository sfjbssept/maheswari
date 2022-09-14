package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Services.IStudentService;
import com.crud.entity.Student;
import com.crud.repo.IStudentRepository;


@RestController
public class StudentController {

	@Autowired
	private IStudentRepository studentRepository;
	
	@Autowired
	IStudentService studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student save = this.studentRepository.save(student);
		
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/getStudents")
	public ResponseEntity<?> getStudents() {
		return ResponseEntity.ok(this.studentRepository.findAll());
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
		System.out.println(student.getName()+" "+student.getCity()+" "+student.getCollege());
		//return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
		Student s = studentService.updateStudent(student, id);
		return ResponseEntity.ok(s);
	}
}
