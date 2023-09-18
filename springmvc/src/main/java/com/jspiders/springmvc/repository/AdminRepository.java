package com.jspiders.springmvc.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	
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
	


	public AdminPOJO getAdmin() {
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
	
	public AdminPOJO createAccount(String name, String password) {
		openConnections();
		transaction.begin();
		AdminPOJO pojo=new AdminPOJO();
		pojo.setUsername(name);	
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnections();
		return pojo;
	}
	
	/*public AdminPOJO logIn(String username, String password) {
		openConnections();
		transaction.begin();

		String jpql="from AdminPOJO  where username = '"+ username +"' and password = '"+password+"'";
		query= manager.createQuery(jpql);
		List<AdminPOJO> resultList = query.getResultList();
		if (resultList.isEmpty()==false) {
			for (AdminPOJO pojo : resultList) {
				transaction.commit();
				closeConnections();
				System.out.println(pojo);
				return pojo;
			}
		}
		
		transaction.commit();
		closeConnections();
		return null;
	}*/
	public AdminPOJO logIn(String username, String password) {
		openConnections();
		transaction.begin();
		
		String jpql = "from AdminPOJO "
					+ "where username = '" + username + "' "
					+ "and password = '" + password + "'";
		
		query = manager.createQuery(jpql);
		
		List<AdminPOJO> admins = query.getResultList();
		for (AdminPOJO adminPOJO : admins) {
			System.out.println(adminPOJO.getUsername());
		}
		if (admins.isEmpty() == false) {
			for (AdminPOJO pojo : admins) {
				transaction.commit();
				closeConnections();
				System.out.println(pojo);
				return pojo;
			}
		}
		
		transaction.commit();
		closeConnections();
		return null;
	}

}
