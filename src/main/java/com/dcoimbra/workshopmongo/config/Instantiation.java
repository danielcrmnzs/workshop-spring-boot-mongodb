package com.dcoimbra.workshopmongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dcoimbra.workshopmongo.domain.Post;
import com.dcoimbra.workshopmongo.domain.User;
import com.dcoimbra.workshopmongo.dto.AuthorDTO;
import com.dcoimbra.workshopmongo.dto.CommentDTO;
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

		Post post1 = Post.builder().date(LocalDate.of(2022, 7, 1)).title("Partiu viagem")
				.body("Vou viajar para São Paulo. Abraços!").author(new AuthorDTO(maria)).build();
		Post post2 = Post.builder().date(LocalDate.of(2022, 7, 3)).title("Bom dia").body("Acordei feliz hoje!")
				.author(new AuthorDTO(maria)).build();

		CommentDTO c1 = CommentDTO.builder().text("Boa viagem!").date(LocalDate.of(2022, 7, 1)).author(new AuthorDTO(alex)).build();
		CommentDTO c2 = CommentDTO.builder().text("Aproveite").date(LocalDate.of(2022, 7, 2)).author(new AuthorDTO(bob)).build();
		CommentDTO c3 = CommentDTO.builder().text("Tenha um ótimo dia!").date(LocalDate.of(2022, 7, 3)).author(new AuthorDTO(alex)).build();
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
