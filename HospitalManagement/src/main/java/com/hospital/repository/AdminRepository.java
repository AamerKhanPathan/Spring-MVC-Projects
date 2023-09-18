package com.hospital.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hospital.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	private static EntityManagerFactory factory;
	private static EntityManager  manager;
	private static EntityTransaction transaction;
	private static Query query;
	
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
public AdminPOJO findAccount() {
	openConnections();
	transaction.begin();
	String jpql="from AdminPOJO";
	
	query=manager.createQuery(jpql);
	List <AdminPOJO> admin = query.getResultList();
	if (admin.isEmpty()==false) {
		for (AdminPOJO pojo: admin) {
			transaction.commit();
			closeConnections();
			return pojo;
		}
		
	}
	
	transaction.commit();
	closeConnections();
	return null;
}
public AdminPOJO login(String username, String password) {
openConnections();
transaction.begin();
AdminPOJO admin = manager.find(AdminPOJO.class, username);
System.out.println(admin);

if (admin!=null) {
	
	boolean equalsName = admin.getUsername().equals(username);
		
	boolean equalsPass= admin.getPassword().equals(password);
	
	

	if (equalsPass&&equalsName) {
		transaction.commit();
		closeConnections();
		return admin;
		
	}
}

transaction.commit();
closeConnections();
	return null;
}
public AdminPOJO createAccount(String username, String password) {
	openConnections();
transaction.begin();
AdminPOJO pojo=new AdminPOJO();
pojo.setUsername(username);
pojo.setPassword(password);
manager.persist(pojo);
transaction.commit();
closeConnections();
	return pojo;
}


}
