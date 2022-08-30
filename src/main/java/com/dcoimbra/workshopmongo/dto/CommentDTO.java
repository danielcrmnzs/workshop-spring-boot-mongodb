package com.dcoimbra.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text;
	private LocalDate date;
	private AuthorDTO author;

}
