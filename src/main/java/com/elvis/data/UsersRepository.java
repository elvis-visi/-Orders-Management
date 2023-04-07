package com.elvis.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elvis.models.UserEntity;

public interface UsersRepository extends MongoRepository<UserEntity, String> {

	UserEntity findByUsername(String username);
	
}
