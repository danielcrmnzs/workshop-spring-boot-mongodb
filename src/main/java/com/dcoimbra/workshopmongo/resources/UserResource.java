package com.dcoimbra.workshopmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcoimbra.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = User.builder().id("1").name("Maria Silva").email("maria@email.com").build();
		User alex = User.builder().id("2").name("Alex Green").email("alex@email.com").build();

		return ResponseEntity.ok().body(Arrays.asList(maria, alex));
	}

}
