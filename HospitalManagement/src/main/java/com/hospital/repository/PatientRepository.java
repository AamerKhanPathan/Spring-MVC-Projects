package com.hospital.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.objenesis.instantiator.sun.MagicInstantiator;
import org.springframework.stereotype.Repository;

import com.hospital.pojo.PatientPOJO;
import com.mysql.cj.xdevapi.Result;

@Repository
public class PatientRepository {

	private static EntityManagerFactory factory;
	private static EntityManager  manager;
	private static EntityTransaction transaction;
	private Query query;
	
	public void openConnections() {
		factory=Persistence.createEntityManagerFactory("hospital_management");
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

	public PatientPOJO addPatient(String name, String email, long contact, String address, String disease,String date) {
		openConnections();
		transaction.begin();
		PatientPOJO  pojo=new PatientPOJO();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setAddress(address);
		pojo.setDisease(disease);
		pojo.setNextVisitDate(date);
		manager.persist(pojo);
		transaction.commit();
		closeConnections();
		
		
		return pojo;
	}
	public PatientPOJO searchPatient(int id) {
		openConnections();
		transaction.begin();
		PatientPOJO pojo=new PatientPOJO();
		pojo=manager.find(PatientPOJO.class, id);
		transaction.commit();
		closeConnections();
    	return pojo;
	}
	public PatientPOJO removePatient(int id) {
		openConnections();
		transaction.begin();
		PatientPOJO pojo=new PatientPOJO();
		pojo=manager.find(PatientPOJO.class, id);
		if (pojo!=null) {
			manager.remove(pojo);
		}
		
		transaction.commit();
		closeConnections();
    	return pojo;
	}
	public List<PatientPOJO> getPatients() {
		openConnections();
		transaction.begin();
		String jpql="from PatientPOJO";
		query  = manager.createQuery(jpql);
		List<PatientPOJO> patients = query.getResultList();
		transaction.commit();
		closeConnections();
		return patients;
	}

	public PatientPOJO updatepatient(int id, String name, long contact, String email, String deisease, String date) {
		openConnections();
		transaction.begin();
		PatientPOJO pojo=new PatientPOJO();
		pojo=manager.find(PatientPOJO.class, id);

		pojo.setName(name);
		pojo.setContact(contact);
		pojo.setEmail(email);
		pojo.setDisease(deisease);
		pojo.setNextVisitDate(date);
		manager.persist(pojo);
		
		
		transaction.commit();
		closeConnections();
		return pojo;
	}

}
