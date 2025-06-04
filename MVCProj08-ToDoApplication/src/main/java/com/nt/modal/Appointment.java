package com.nt.modal;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "APPOINTMENTS")
@RequiredArgsConstructor
@NoArgsConstructor
public class Appointment 
{
	
	@Id
	@SequenceGenerator(name = "app_seq",sequenceName = "appSeq",initialValue =100,allocationSize = 1 )
	@GeneratedValue(generator = "app_seq",strategy = GenerationType.SEQUENCE)
	private Integer id;
	@NonNull
	@Column(length = 40)
	private String title;
	
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime appDate;
	
	@Column(length = 40)
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "user_id")	
	private User user;
	

}
