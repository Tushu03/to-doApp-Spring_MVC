package com.nt.repositery;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.modal.Appointment;
import com.nt.modal.User;

public interface IAppointementRepo extends JpaRepository<Appointment, Integer> 
{
	public List<Appointment> getAppointmentByUser(User user);

}
