package com.dcoimbra.workshopmongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcoimbra.workshopmongo.domain.Post;
import com.dcoimbra.workshopmongo.repositories.PostRepository;
import com.dcoimbra.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> optPost = postRepository.findById(id);
		return optPost.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
	}

	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
		return postRepository.fullSearch(text, minDate, maxDate);
	}

}
