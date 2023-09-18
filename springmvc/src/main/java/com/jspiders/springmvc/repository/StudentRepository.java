package com.jspiders.springmvc.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.StudentPOJO;

@Repository
public class StudentRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	public void openConnections() {
		
		factory=Persistence.createEntityManagerFactory("mvc");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
	}
	public void closeConnections() {
		if (factory!=null) {
			factory.close();
		}
		
		if (manager!=null) {
			manager.close();
		}
		if (transaction!=null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	

	
	public StudentPOJO addStudent(String name, String email, Long contact, String address) {
		
		openConnections();
		transaction.begin();
		StudentPOJO student=new StudentPOJO();
		student.setName(name);
		student.setEmail(email);
		student.setContact(contact);
		student.setAddress(address);
		
		manager.persist(student);
		transaction.commit();
		closeConnections();
		
		
		return student;
	}
	public StudentPOJO searchStudent(int id) {
		openConnections();
		transaction.begin();
		StudentPOJO student=new StudentPOJO();
		student=manager.find(StudentPOJO.class, id);
		transaction.commit();
		closeConnections();
		return student;
	}
	public StudentPOJO removeStudent(int id) {
		openConnections();
		transaction.begin();
		StudentPOJO student=new StudentPOJO();
		student=manager.find(StudentPOJO.class, id);
		if (student!=null) {
			manager.remove(student);
		}
		
		
		transaction.commit();
		closeConnections();
		return student;
	}
	public List<StudentPOJO> findAllStudents() {
		openConnections();
		transaction.begin();
		
		String jpql="from StudentPOJO";
		query=manager.createQuery(jpql);
		List<StudentPOJO> students=query.getResultList();
		
		transaction.commit();
		closeConnections();
		return students;
	}
	public StudentPOJO updateStudent(int id, String name, String email, long contact, String address) {
		
		openConnections();
		transaction.begin();
		
		StudentPOJO pojo = manager.find(StudentPOJO.class, id);
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setAddress(address);
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnections();
		return pojo;
		
	}

}
