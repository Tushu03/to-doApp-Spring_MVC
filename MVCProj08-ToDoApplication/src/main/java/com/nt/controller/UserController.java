package com.nt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.modal.Appointment;
import com.nt.modal.User;
import com.nt.repositery.IAppointementRepo;
import com.nt.service.IAppointmentService;
import com.nt.service.IUserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController 
{
	@Autowired
	private IUserService service;
	
	@Autowired
	private  IAppointmentService appService;
	
	@RequestMapping({"/","/loginpage"})
	public String showHome() {
		return "login";
	}
	@GetMapping("/registerpage")
	public String showRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user")User user, Model model) 
	{
		System.out.println("ShowHomeController.registerUser()");
		User user1=service.findByName(user.getName());
		if(user1==null) 
		{
			User registerUser = service.registerUser(user);
			return "login";
			
		}
		else {
			model.addAttribute("error", "User Already Exists!");
			return "register";
		}		
		
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam()String name,@RequestParam String pass,Model model,HttpSession session) 
	{
		User user = service.findByName(name);
		if(user!=null) 
		{
			 if (user.getName().equals(name) && user.getPass().equals(pass)) {
		            model.addAttribute("message", "Login successful!");
		            model.addAttribute("user",user.getName());
		            session.setAttribute("loggeduser", user);
		            
		            //set appointments 
		            List<Appointment> list = appService.getAppointmentsByUser(user);
		            model.addAttribute("appointments",list);
		            
		            
		            return "dashboard"; 
		        } else {
		            model.addAttribute("error", "Invalid username or password.");
		            return "login"; 
		        }
		}
		else {
			 model.addAttribute("error", "User Not Exists.");
	            return "login"; 
		}		
		
	}
	 @PostMapping("/logout")
	    public String logout(HttpSession session) {
	        session.removeAttribute("loggeduser"); 
	        return "redirect:/loginpage"; 
	    }
}
