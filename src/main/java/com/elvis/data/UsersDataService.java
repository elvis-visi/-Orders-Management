package com.elvis.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvis.models.UserEntity;

@Service
public class UsersDataService implements UsersDataInterface<UserEntity> {

	@Autowired
	private UsersRepository usersRepository;
	
	//non default constructor for constructor injection.
	public UsersDataService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	
	@Override
	public UserEntity findByUsername(String username) {
		
		return usersRepository.findByUsername(username);
	}



}
