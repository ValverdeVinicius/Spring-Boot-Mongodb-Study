package com.viniciusvalverde.estudomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.viniciusvalverde.estudomongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
}
