package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.modal.User;
import com.nt.repositery.IUserRepo;

@Service
public class IUserServiceImpl implements IUserService 
{
	@Autowired
	private IUserRepo repo;
	public User registerUser(User user) 
	{
		System.out.println(">>> User before save: " + user);
	    User saved = repo.save(user);
	    System.out.println(">>> User after save: " + saved);
	    return saved;
		
	}
	@Override
	public User findByName(String name) 
	{
		User user = repo.findByName(name);
		
		return user;
				
	}

	
	
}
