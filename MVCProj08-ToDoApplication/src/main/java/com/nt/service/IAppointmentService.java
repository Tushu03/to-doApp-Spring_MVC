package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.modal.Appointment;
import com.nt.modal.User;

public interface IAppointmentService 
{
	public Appointment addAppointment(Appointment app);
	public List<Appointment> getAppointmentsByUser(User user);
	
	public Appointment findById(Integer id);
	public String deleteAppointmentFromUser(Integer appointmentId, User user);
	
	public String editAppointementByApp(Appointment app);
	public  Page<Appointment> getAppointmentByPageWithUser(Pageable pagaeble,User user);

	

	

}
