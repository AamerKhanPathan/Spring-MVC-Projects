package com.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.pojo.AdminPOJO;
import com.hospital.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository repository;

	public AdminPOJO findAccount() {
		AdminPOJO pojo=repository.findAccount();
		return pojo;
	}

	public AdminPOJO logIn(String username, String password) {
		AdminPOJO pojo=repository.login(username,password);
		return pojo;
	}

	public AdminPOJO createAccount(String username, String password) {
AdminPOJO pojo=repository.createAccount( username,  password) ;
		return pojo;
	}

}
