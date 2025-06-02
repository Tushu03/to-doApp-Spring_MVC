package com.nt.modal;



import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data

@Table(name="TODO_USERS")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class User 
{
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "user_seq",allocationSize = 1,initialValue = 100)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	@NonNull
	@Column(length = 15)
	private String name;
	@Column(length = 15)
	@NonNull
	private String address;
	@NonNull
	private Long contact;
	@Column(length = 25)
	@NonNull
	private String email;
	@NonNull
	@Column(length = 20)
	private String pass;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<>();

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", email="
				+ email + ", pass=" + pass + "]";
	}

	
	
	

}
