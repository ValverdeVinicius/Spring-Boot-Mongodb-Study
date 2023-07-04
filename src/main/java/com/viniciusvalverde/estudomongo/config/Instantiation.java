package com.viniciusvalverde.estudomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciusvalverde.estudomongo.domain.Post;
import com.viniciusvalverde.estudomongo.domain.User;
import com.viniciusvalverde.estudomongo.dto.AuthorDTO;
import com.viniciusvalverde.estudomongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(maria, alex, craudio));
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Bom dia grupo", "Que esse dia seja abençoado!",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("14/07/2023"), "Estou indo viajar", "Vou para São Paulo hoje!",new AuthorDTO(alex));
		
		CommentDTO c1 = new CommentDTO("Bom diaaa", sdf.parse("21/03/2023"), new AuthorDTO(craudio));
		CommentDTO c2 = new CommentDTO("Boa viagem!", sdf.parse("14/07/2023"), new AuthorDTO(craudio));
		
		post1.getComments().addAll(Arrays.asList(c1));
		post2.getComments().addAll(Arrays.asList(c2));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().add(post1);
		alex.getPosts().add(post2);
		
		userRepository.saveAll(Arrays.asList(maria,alex));		
	}
}