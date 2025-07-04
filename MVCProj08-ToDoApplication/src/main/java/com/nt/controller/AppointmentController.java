package com.nt.controller;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String backToDashboard(@PageableDefault(page = 0,size = 4) Pageable pageable,@RequestParam(required = false) String sort,HttpSession session,Model model) {
		 User user = (User) session.getAttribute("loggeduser");
		    if (user != null) {
		    	Page<Appointment> page=service.getAppointmentByPageWithUser(pageable,user);
		    	
		    	
		        if (sort != null) {
		            switch (sort) {
		                case "title":
		                    page.stream().sorted((a1,a2)->a1.getTitle().compareTo(a2.getTitle()));
		                    break;
		                case "date":
		                    page.stream().sorted(Comparator.comparing(Appointment::getAppDate));
		                    break;
		            }
		        }
		        model.addAttribute("user", user.getName());
		        model.addAttribute("appointments", page);
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
            					RedirectAttributes redirattrs,
            					Model model) 
	{
		User user=(User) session.getAttribute("loggeduser");
		
		//get appointements of loggedin user
		
		
		
		LocalDateTime date=LocalDateTime.parse(dateTime);
		Appointment appointment=new Appointment(title, date);
		appointment.setNote(notes);
		appointment.setUser(user);
		try {
			 service.addAppointment(appointment);
			 redirattrs.addFlashAttribute("successMsg", "Appointment saved successfully!");
		}
		catch (Exception e) {
			 redirattrs.addFlashAttribute("errorMsg", "Failed to save appointment.");
		}
		
		
		
		
		
		
		return "redirect:/dashboard";
		
		
	}
	
	@Transactional
	@RequestMapping("/appointment/delete/{id}")
	public String deleteAppointment(@PathVariable("id") Integer id, HttpSession session) {
	    User user = (User) session.getAttribute("loggeduser");
	    service.deleteAppointmentFromUser(id, user);
	    return "redirect:/dashboard";
	}
	
	
	
	
	
	@RequestMapping("/appointments/editPage/{id}") //for displaying edit page
	public String editAppointmentPage(@PathVariable("id")Integer id, Model model) 
	{
		Appointment appointment=service.findById(id);
		model.addAttribute("app",appointment);
		
		
		return "edit";
		
	}
	
	
	@PostMapping("/appointments/edit")
	public String editAppointment(@ModelAttribute("app") Appointment app, RedirectAttributes redir) 
	{
		
		try {
			String msg=service.editAppointementByApp(app);
			redir.addFlashAttribute("successMsg",msg);
			System.out.println(msg);
			
		}
		catch(Exception e) 
		{
			redir.addFlashAttribute("errorMsg","Failed to Edit Appointment");
			
		}
		
		return "redirect:/dashboard";
		
	}

	

}
