package com.orangetalent5.casadocodigo.resources;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalent5.casadocodigo.domain.Livro;
import com.orangetalent5.casadocodigo.dto.LivroFormDTO;
import com.orangetalent5.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private EntityManager manager;

	@Autowired
	private LivroRepository livroRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@Valid @RequestBody LivroFormDTO form) {
		Livro livro = form.toEntity(manager);
		livroRepository.save(livro);

		return ResponseEntity.ok().build();
	}

}
