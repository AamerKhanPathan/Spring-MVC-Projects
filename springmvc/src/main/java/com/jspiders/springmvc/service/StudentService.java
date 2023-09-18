package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	

	public StudentPOJO addStudent(String name, String email, Long contact, String address) {
			StudentPOJO student=repository.addStudent(name,email,contact,address);
		
		return student;
	}



	public StudentPOJO searchStudent(int id) {
		StudentPOJO student=repository.searchStudent(id);
		return student;
	}



	public StudentPOJO removeStudent(int id) {
		StudentPOJO student=repository.removeStudent(id);
		return student;
	}



	public List<StudentPOJO> findAllStudents() {
		
		List<StudentPOJO> students=repository.findAllStudents();
		return students;
	}



	public StudentPOJO updateStudent(int id, String name, String email, long contact, String address) {
		StudentPOJO pojo=repository.updateStudent(id,name,email,contact,address);
		return pojo;
	}

}
