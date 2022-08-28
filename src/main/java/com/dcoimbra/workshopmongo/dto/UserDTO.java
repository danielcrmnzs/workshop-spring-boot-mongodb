package com.dcoimbra.workshopmongo.dto;

import java.io.Serializable;

import com.dcoimbra.workshopmongo.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;

	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}
}
