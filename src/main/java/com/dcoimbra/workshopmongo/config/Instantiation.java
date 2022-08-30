package com.dcoimbra.workshopmongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dcoimbra.workshopmongo.domain.Post;
import com.dcoimbra.workshopmongo.domain.User;
import com.dcoimbra.workshopmongo.dto.AuthorDTO;
import com.dcoimbra.workshopmongo.repositories.PostRepository;
import com.dcoimbra.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = User.builder().id(null).name("Maria Brown").email("maria@email.com").build();
		User alex = User.builder().id(null).name("Alex Green").email("alex@email.com").build();
		User bob = User.builder().id(null).name("Bob Grey").email("bob@email.com").build();

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, LocalDate.of(2022, 7, 1), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDate.of(2022, 7, 3), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
