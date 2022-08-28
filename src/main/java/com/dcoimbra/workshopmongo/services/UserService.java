package com.dcoimbra.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcoimbra.workshopmongo.domain.User;
import com.dcoimbra.workshopmongo.dto.UserDTO;
import com.dcoimbra.workshopmongo.repositories.UserRepository;
import com.dcoimbra.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> optUser = userRepository.findById(id);
		return optUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

}
