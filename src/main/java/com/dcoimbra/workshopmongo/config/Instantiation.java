package com.dcoimbra.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dcoimbra.workshopmongo.domain.User;
import com.dcoimbra.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User maria = User.builder().id(null).name("Maria Brown").email("maria@email.com").build();
		User alex = User.builder().id(null).name("Alex Green").email("alex@email.com").build();
		User bob = User.builder().id(null).name("Bob Grey").email("bob@email.com").build();

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
