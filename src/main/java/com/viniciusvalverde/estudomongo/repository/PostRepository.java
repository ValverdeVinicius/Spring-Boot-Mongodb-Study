package com.viniciusvalverde.estudomongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.viniciusvalverde.estudomongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	// ?0 in regex is to gather the first parameter from the method
	// i is to ignore cases and turn the expression to case insensitive
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
