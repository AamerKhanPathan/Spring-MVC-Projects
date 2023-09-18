package com.hospital.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.pojo.AdminPOJO;
import com.hospital.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService service;
	
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map) {
		AdminPOJO pojo=service.findAccount();
			
		if (pojo!=null) {
			map.addAttribute("msg","user already exists");
			return "LogIn";
			
		}
		return "CreateAccount";
		
		
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,
			  @RequestParam String password
			   ,ModelMap map) {

AdminPOJO pojo=service.createAccount(username,password);
if (pojo!=null) {
map.addAttribute("msg","account created successfully :)");
return "LogIn";
}
map.addAttribute("msg","sorry :( account not created");
return "LogIn";
}
	
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password,ModelMap map,HttpSession session) {
		
		AdminPOJO pojo=service.logIn(username,password);
		if (pojo!=null) {
			session.setAttribute("login", pojo);
			return "Home";
		}
		map.addAttribute("msg", "invalide username or passwaord");
		return "LogIn";
		
	}

	
	
}
