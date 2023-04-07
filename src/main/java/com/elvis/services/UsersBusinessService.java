package com.elvis.services;

import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elvis.data.UsersDataService;
import com.elvis.models.UserEntity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



//UserDetailsService required by the Spring Security framework to support authentication
@Service
public class UsersBusinessService  implements UserDetailsService{

	@Autowired
	private UsersDataService service;

	//non default constructor for injection
	public UsersBusinessService(UsersDataService service) {
		this.service = service;
	}

	//retrieve a user's details based on their username during the authentication process
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("UsersBusinessService is searching for " + username);
		//try finding the user in th DB, if not found throw exception
		UserEntity user = service.findByUsername(username);
		
		
		if(user != null)
		{
			System.out.println(user);
			// list of GrantedAuthority objects representing the user's roles
			List<GrantedAuthority> authorities =  new ArrayList<GrantedAuthority>();
			for(String role :user.getRoles())
			{
				System.out.println("role ---> " + role);
				
				authorities.add(new SimpleGrantedAuthority(role));
			}
			// UserDetails object is used to authenticate the user and manage their 
			//roles/permissions within the application.
			return new User(user.getUsername(), user.getPassword(), authorities);
			
		}
		else {
			System.out.println("User not found");
			throw new UsernameNotFoundException("username not found");
		}
		
		
	}
	
	
	
	
	
}
