package com.orangetalent5.casadocodigo.resources;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalent5.casadocodigo.domain.Author;
import com.orangetalent5.casadocodigo.dto.AuthorFormDTO;
import com.orangetalent5.casadocodigo.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorRepository authRepository;

	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@Valid @RequestBody AuthorFormDTO form) {
		Author author = form.toEntity();
		authRepository.save(author);

		return ResponseEntity.ok().build();
	}
	
	
	
}
