package com.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hospital.pojo.AdminPOJO;
import com.hospital.pojo.PatientPOJO;
import com.hospital.service.PatientService;

@Controller
public class HospitalController {
	@Autowired
	private PatientService service;
	
	//Home Page
	@GetMapping("/home")
	public String home(@SessionAttribute(name="login",required = false) AdminPOJO admin,ModelMap map) {
		if (admin!=null) {
			return "Home";	
		}
		map.addAttribute("msg","please long in for further proceed");
		return "LogIn";
	}
	
	//Add Page
	@GetMapping("/add")
	public String add(@SessionAttribute(name="login",required = false) AdminPOJO admin,ModelMap map) {
		if (admin!=null) {
			
		
		//for getting all records
		List<PatientPOJO> patients=service.getPatients();
		
		if (!patients.isEmpty()) {
			map.addAttribute("patients", patients);
			return "Add";
		}
		map.addAttribute("msg", "no record present..");
		return "Add";
		}
		else {
			map.addAttribute("msg","please long in for further proceed");
			return "LogIn";
		}
	}
	
	//Add Patient
	@PostMapping("/add")
	public String addPatient(@RequestParam String name,
							 @RequestParam String email,
							 @RequestParam long contact,
							 @RequestParam String address,
							 @RequestParam String disease,
							 @RequestParam String date,
							 ModelMap map,@SessionAttribute(name="login",required = false) AdminPOJO admin) {
		if (admin!=null) {
			
		
		PatientPOJO pojo=service.addPatient(name, email, contact, address, disease, date);
		
		List<PatientPOJO> patients=service.getPatients();
		if (pojo!=null) {
			map.addAttribute("msg", "data inserted successfully");
			map.addAttribute("patients", patients);
			return "Add";
		}
		map.addAttribute("patients", patients);
		map.addAttribute("msg", "data not  inserted ");
		return "Add";
	}
		else {
			map.addAttribute("msg","please long in for further proceed");
			return "LogIn";
		}
	}
	
	//Remove Page
	@GetMapping("/remove")
	public String remove(ModelMap map,@SessionAttribute(name="login",required = false) AdminPOJO admin) {
		if (admin!=null) {
			
		
List<PatientPOJO> patients=service.getPatients();
		
		if (!patients.isEmpty()) {
			map.addAttribute("patients", patients);
			return "Remove";
		}
		map.addAttribute("msg", "no record present..");
		return "Remove";
	}
		else {
			map.addAttribute("msg","please long in for further proceed");
			return "LogIn";
		}
	}
	
	//Remove Patient 
	@PostMapping("/remove")
	public String removePatient(@RequestParam int id,
								ModelMap map,@SessionAttribute(name="login",required = false) AdminPOJO admin) {
		List<PatientPOJO> patients=service.getPatients();
		PatientPOJO  pojo=service.removePatient(id);
		if (pojo!=null) {
	    	map.addAttribute("msg", "Removed Record Successfully..");
			map.addAttribute("patients", patients);
			return "Remove";
		}
		map.addAttribute("msg", "Invalid Id for Remove Record");
		map.addAttribute("patients",patients);
			return "Remove";
	}
	
	//Update Page
	@GetMapping("/update")
	public String update(ModelMap map,@SessionAttribute(name="login",required = false) AdminPOJO admin){
		if (admin!=null) {
			
		
List<PatientPOJO> patients=service.getPatients();
		
		if (!patients.isEmpty()) {
			map.addAttribute("patients", patients);
			return "Update";
		}
		map.addAttribute("msg", "no record present..");
		return "Update";
	}
		else {
			map.addAttribute("msg","please long in for further proceed");
			return "LogIn";
		}
	}
	
	//get update form
	
	@PostMapping("/update")
	public String updateForm(@RequestParam int id,ModelMap map,@SessionAttribute(name="login",required = false) AdminPOJO admin) {
		
		PatientPOJO pojo =service.searchPatient(id);
		if (pojo!=null) {
			
			map.addAttribute("pojo",pojo);
			return "Update";
		}
		map.addAttribute("msg", "Recond not found");
		List<PatientPOJO> patients=service.getPatients();
		map.addAttribute("patients", patients);
		return "Update";
	}
	
	//update patient details
	@PostMapping("/updatePatient")
	public String updatePatient(@RequestParam int id,@RequestParam String name,@RequestParam long contact,
								@RequestParam String email,@RequestParam String deisease,@RequestParam String date
								,@RequestParam String address,ModelMap map ,
								@SessionAttribute(name="login",required = false) AdminPOJO admin) {
		if (admin!=null) {
			
		
		PatientPOJO pojo=service.updatepatient(id,name,contact,email,deisease,date);
		if (pojo!=null) {
			map.addAttribute("msg", "Data successfully updated ..!");
			List<PatientPOJO> patients=service.getPatients();
			map.addAttribute("patients", patients);
			return "Update";	
		}
		return "Update";
	}
		else {
			map.addAttribute("msg","please long in for further proceed");
			return "LogIn";
		}
	}
	//Search Page
	@GetMapping("/search")
	public String search(@SessionAttribute(name="login",required = false) AdminPOJO admin,ModelMap map) {
		if (admin!=null) {
			
		
		return "Search";
		}
		else {
			map.addAttribute("msg","please long in for further proceed");
			return "LogIn";
		}
	}
	
	//Search Patients 
	@PostMapping("/search")
	public String searchPatient(@RequestParam int id,
								ModelMap map,@SessionAttribute(name="login",required = false) AdminPOJO admin
								) {
		if (admin!=null) {
			
		
	PatientPOJO pojo=service.searchPatient(id);
	
	if (pojo!=null) {
		map.addAttribute("pojo",pojo);
		
		return "Search";
	}
	map.addAttribute("msg", "Recond not found");
		return "Search";
	}
		else {
			map.addAttribute("msg","please long in for further proceed");
			return "LogIn";
		}
	
	}
	
	
	//logIn Page
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "LogIn";
	}
	
	
}
