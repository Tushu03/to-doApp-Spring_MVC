package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.modal.Appointment;
import com.nt.modal.User;
import com.nt.repositery.IAppointementRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class IAppointmentServiceImpl implements IAppointmentService{

	@Autowired
	private IAppointementRepo repo;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Appointment addAppointment(Appointment app) 
	{
		
		return repo.save(app);
	}
	@Override
	public List<Appointment> getAppointmentsByUser(User user) 
	{
		
		
		return repo.getAppointmentByUser(user);
	}
	@Override
	public Appointment findById(Integer id) {
		
		return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Appointment Not Found "));
	}
	@Transactional
	@Override
	public String deleteAppointmentFromUser(Integer appointmentId, User user) {
	    Appointment appointment = repo.findById(appointmentId)
	        .orElseThrow(() -> new RuntimeException("Appointment not found"));

	    
	    
	    	 User managedUser = entityManager.find(User.class, user.getId());
	 	    managedUser.getAppointments().remove(appointment);
	 	    repo.delete(appointment);
	 	    
	     return appointmentId+" Id Appointement deleted";
	   
	}
	
	@Override
	public String editAppointementByApp(Appointment app) 
	{	
		
		    Appointment existing = repo.findById(app.getId()).orElseThrow(()->new IllegalArgumentException("Appointement not found"));
		    if (existing != null) {
		        existing.setTitle(app.getTitle());
		        existing.setAppDate(app.getAppDate());
		        existing.setNote(app.getNote());
		        repo.save(existing); 
		        return app.getId()+" Appointment updated successfully";
		    } else {
		        return " Appointment not found";
		    }
		

		
		//return repo.save(app).getId()+" Appointement Updated ";
	}


	

}
