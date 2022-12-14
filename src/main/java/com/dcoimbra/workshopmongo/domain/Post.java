package com.dcoimbra.workshopmongo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dcoimbra.workshopmongo.dto.AuthorDTO;
import com.dcoimbra.workshopmongo.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	private String id;
	private LocalDate date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	@Builder.Default
	private List<CommentDTO> comments = new ArrayList<>();

}
