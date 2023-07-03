package com.viniciusvalverde.estudomongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciusvalverde.estudomongo.domain.User;
import com.viniciusvalverde.estudomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Matos", "alex@gmail.com");
		User craudio = new User(null, "Craudio dos Santos", "craudio@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, craudio));
		
	}
}