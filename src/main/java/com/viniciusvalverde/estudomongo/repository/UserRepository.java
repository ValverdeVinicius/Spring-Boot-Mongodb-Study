package com.viniciusvalverde.estudomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.viniciusvalverde.estudomongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
