package com.viniciusvalverde.estudomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniciusvalverde.estudomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
