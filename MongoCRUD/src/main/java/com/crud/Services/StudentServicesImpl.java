package com.crud.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.repo.IStudentRepository;

@Service
public class StudentServicesImpl implements IStudentService{
	
	@Autowired
	IStudentRepository studentRepository;
	
	@Override
	public Student updateStudent(Student student, Integer Id) {
		Student existingProduct = studentRepository.findById(Id).get();
		
				existingProduct.setName(student.getName());
				existingProduct.setCollege(student.getCollege());
				existingProduct.setCity(student.getCity());
				
	
				
				studentRepository.save(existingProduct);
				return existingProduct;
				
	}


}
