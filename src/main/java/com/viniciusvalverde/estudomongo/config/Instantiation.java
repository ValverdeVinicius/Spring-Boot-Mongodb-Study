package com.viniciusvalverde.estudomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciusvalverde.estudomongo.domain.Post;
import com.viniciusvalverde.estudomongo.domain.User;
import com.viniciusvalverde.estudomongo.repository.PostRepository;
import com.viniciusvalverde.estudomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Matos", "alex@gmail.com");
		User craudio = new User(null, "Craudio dos Santos", "craudio@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Bom dia grupo", "Que esse dia seja abençoado!",maria);
		Post post2 = new Post(null, sdf.parse("14/07/2023"), "Estou indo viajar", "Vou para São Paulo hoje!",alex);
		
		userRepository.saveAll(Arrays.asList(maria, alex, craudio));
		postRepository.saveAll(Arrays.asList(post1,post2));
		
	}
}