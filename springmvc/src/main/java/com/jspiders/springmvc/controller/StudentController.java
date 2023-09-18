package com.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	//Generic request just for understanding purpose i take requsetMapping
	//@RequestMapping(path ="/home", method = RequestMethod.GET )
	@GetMapping("/home")
	public String home(@SessionAttribute(name="login",required = false) AdminPOJO admin,ModelMap map) {
		
		if (admin!=null) {
			return "Home";
		}
		map.addAttribute("msg","please long in for further proceed");
		return "Login";
	}
	
	//Add Page 
	@GetMapping("/add")
	public String addPage(ModelMap map,@SessionAttribute(name = "login",required = false) AdminPOJO admin) {
		
		if (admin!=null) {
			List<StudentPOJO> students=service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students",students);
				return "Add";
			}
			else {
				map.addAttribute("msg","no data present..!");
				return "Add";
			}
		}
		map.addAttribute("msg","please long in for further proceed");
		return "Login";
		
	}
	
	//Add student
	@PostMapping("/add")
	public String  addStudent(@SessionAttribute(name="login",required = false) AdminPOJO admin,@RequestParam String name,
			                   @RequestParam String email,
			                   @RequestParam Long contact,
			                   @RequestParam String address,
			                   ModelMap map) {
		if (admin!=null) {
			StudentPOJO student= service.addStudent(name,email,contact,address);
		    
		    
		    //success 
		    if (student!=null) {
		    	map.addAttribute("msg","data inserted successfully");
		    	List<StudentPOJO> students=service.findAllStudents();
		    	map.addAttribute("students",students);
		    	return "Add";
			}
		    
				map.addAttribute("msg", "opps data not inserted");
				List<StudentPOJO> students=service.findAllStudents();
		    	map.addAttribute("students",students);
				return "Add";
			
		}
		map.addAttribute("msg","please long in for further proceed");
		return "Login";
		}
	    
	

//Remove Page
@GetMapping("/remove")
public String removePage(@SessionAttribute(name="login",required = false) AdminPOJO admin,ModelMap map) {
	
	if (admin!=null) {
		List<StudentPOJO> students=service.findAllStudents();
		
		if (!students.isEmpty()) {
			map.addAttribute("students",students);	
			return "Remove";
		}
		else {
			map.addAttribute("msg","no data present..!");
			return "Remove";
		}
	}
	map.addAttribute("msg","please long in for further proceed");
	return "Login";
	

	
	
}


//Remove Student
@PostMapping("/remove")
public String removeStudent(@SessionAttribute(name="login",required = false) AdminPOJO admin,@RequestParam int id,
							ModelMap map) {
	
	if (admin!=null) {
		StudentPOJO pojo=service.removeStudent(id);
		List<StudentPOJO> students=service.findAllStudents();
		
		//success
		if (pojo != null) {
			map.addAttribute("msg", "Data successfully removed ..!");
			
			map.addAttribute("students", students);
			return "Remove";
		}
		//Failure
		map.addAttribute("msg", "Data does not exist..!");
		
		map.addAttribute("students", students);
		
		return "Remove";
	}
	
	map.addAttribute("msg","please long in for further proceed");
	return "Login";
	
	
}

//Update Student Page
@GetMapping("/update")
public String updatePage( @SessionAttribute(name="login",required = false) AdminPOJO admin,ModelMap map) {
	
	if (admin!=null) {
		List<StudentPOJO> students=service.findAllStudents();
		
		if (!students.isEmpty()) {
			map.addAttribute("students",students);	
			return "Update";
		}
		map.addAttribute("msg","no records found, insert students records to see");
		
		return "Update";
	}
	map.addAttribute("msg","please long in for further proceed");
	return "Login";
	}
		
	
//update Form
@PostMapping("/update")
public String updateForm(@SessionAttribute(name="login",required = false) AdminPOJO admin,@RequestParam int id ,ModelMap map) {
	
	if (admin!=null) {
		StudentPOJO pojo=service.searchStudent(id);
		if (pojo != null) {
			map.addAttribute("student",pojo);
			return "Update";
		}
		map.addAttribute("msg", "no recort found to update");
		List<StudentPOJO> students=service.findAllStudents();
		map.addAttribute("students",students);
		return"Update";
	}
	map.addAttribute("msg","please long in for further proceed");
	return "Login";
	
}

//Update Student
@PostMapping("/updateStudent")
public String updateStudent(@SessionAttribute(name="login",required = false) AdminPOJO admin,ModelMap map,@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam long contact, @RequestParam String address) {
	
	if (admin!=null) {
		StudentPOJO pojo=service.updateStudent(id,name,email,contact,address);
		if (pojo != null) {
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("msg", "Data successfully updated ..!");
			map.addAttribute("students", students);
			return "Update";
		}
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("msg", "Data not updated..!");
		map.addAttribute("students", students);
		return "Update";
	}
	map.addAttribute("msg","please long in for further proceed");
	return "Login";
	
}


	

@GetMapping("/search")
public String searchPage(@SessionAttribute(name="login",required = false) AdminPOJO admin,ModelMap map) {
	if (admin!=null) {
		return "Search";
	}
	map.addAttribute("msg","please long in for further proceed");
	return "Login";
	
	
	
}

//Search Student
@PostMapping("/search")
public String searchStudent(@SessionAttribute(name="login",required = false) AdminPOJO admin,@RequestParam int id,
							ModelMap map){
	
	if (admin!=null ) {
		StudentPOJO student= service.searchStudent(id);
		
		//success flow
			if (student!=null) {
				map.addAttribute("student", student);
				return "Search";
			}
			 //failure flow
			map.addAttribute("student", student);
			 map.addAttribute("msg", "no record found..!");
				return "Search";
	}
	map.addAttribute("msg","please long in for further proceed");
	return "Login";
	

}

//Log out
	@GetMapping("/logout")
	public String login(HttpSession session) {
		session.invalidate();
		return "Login";
	}
}
