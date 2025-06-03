package com.nt.controller;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.modal.Appointment;
import com.nt.modal.User;
import com.nt.service.IAppointmentService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class AppointmentController 
{
	@Autowired
	private IAppointmentService service;
	
	@RequestMapping("/dashboard")
	public String backToDashboard(@RequestParam(required = false) String sort,HttpSession session,Model model) {
		 User user = (User) session.getAttribute("loggeduser");
		    if (user != null) {
		        List<Appointment> appointments = service.getAppointmentsByUser(user);
		        if (sort != null) {
		            switch (sort) {
		                case "title":
		                    appointments.sort((a1,a2)->a1.getTitle().compareTo(a2.getTitle()));
		                    break;
		                case "date":
		                    appointments.sort(Comparator.comparing(Appointment::getAppDate));
		                    break;
		            }
		        }
		        model.addAttribute("user", user.getName());
		        model.addAttribute("appointments", appointments);
		    }
		    return "dashboard";
		
	}
	
	@RequestMapping("/appPage")
	public String addPage() {
		return "addappointment";
	}
	
	@Transactional
	@RequestMapping("/appointment/deleteConfirm/{id}")
	public String DeleteConfirmation(@PathVariable("id") Integer id,Model model) 
	{
		
		Appointment app1 = service.findById(id);
		
		model.addAttribute("appointment",app1);
		
		return "delete";
		
		
	}
	
	
	@RequestMapping("/appointments/add") 
	public String addAppointment(@RequestParam String title,
            					@RequestParam String dateTime,  // Format: 2025-06-01T15:30
            					@RequestParam(required = false) String notes,
            					HttpSession session,
            					Model model) 
	{
		User user=(User) session.getAttribute("loggeduser");
		
		//get appointements of loggedin user
		List<Appointment> list = service.getAppointmentsByUser(user);
		
		
		LocalDateTime date=LocalDateTime.parse(dateTime);
		Appointment appointment=new Appointment(title, date);
		appointment.setNote(notes);
		appointment.setUser(user);
		service.addAppointment(appointment);
		model.addAttribute("user",user.getName());
		model.addAttribute("appointments",list);
		
		
		
		return "redirect:/dashboard";
		
		
	}
	
	
	
	@RequestMapping("/appointments/edit/{id}")
	public String editAppointment(@PathVariable("id")Integer id) 
	{
		return "";
		
	}
	@Transactional
	@RequestMapping("/appointment/delete/{id}")
	public String deleteAppointment(@PathVariable("id") Integer id, HttpSession session) {
	    User user = (User) session.getAttribute("loggeduser");
	    service.deleteAppointmentFromUser(id, user);
	    return "redirect:/dashboard";
	}

	

}
