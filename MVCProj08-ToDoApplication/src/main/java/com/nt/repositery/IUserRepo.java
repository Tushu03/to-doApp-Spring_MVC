package com.nt.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.nt.modal.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer>
{
	

	public User findByName(String name);
		
	
}
