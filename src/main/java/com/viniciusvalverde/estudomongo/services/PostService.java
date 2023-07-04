package com.viniciusvalverde.estudomongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusvalverde.estudomongo.domain.Post;
import com.viniciusvalverde.estudomongo.repository.PostRepository;
import com.viniciusvalverde.estudomongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Post not found!"));
	}
}