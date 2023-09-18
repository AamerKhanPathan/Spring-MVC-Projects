package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService service;
	
	//Create Account Page
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map){
		AdminPOJO pojo=service.getAdmin();
		if (pojo!=null) {
			map.addAttribute("msg","user already exists");
			return "Login";	
		}
		
		return "CreateAccount";
	}
//create account controller
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,
							  @RequestParam String password
							   ,ModelMap map) {
		
		AdminPOJO pojo=service.createAccount(username,password);
		if (pojo!=null) {
			map.addAttribute("msg","account created successfully :)");
			return "Login";
		}
		map.addAttribute("msg","sorry :( account not created");
		return "Login";
	}
	
	
	//login credential match
	@PostMapping("/login")
	public String logIn(@RequestParam String username,
						@RequestParam String password,
						ModelMap map,HttpSession session
						) {
		
		
		AdminPOJO pojo=service.logIn(username,password);
		
		if (pojo!=null) {
			session.setAttribute("login", pojo);
			return "Home";
		}
		
		map.addAttribute("msg", "invalid username or password");
		return "Login";
		
	}
}
