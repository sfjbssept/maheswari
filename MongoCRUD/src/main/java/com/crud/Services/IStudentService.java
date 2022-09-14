package com.crud.Services;

import org.springframework.stereotype.Service;

import com.crud.entity.Student;

@Service
public interface IStudentService {

	Student updateStudent(Student student, Integer Id);
	
}
