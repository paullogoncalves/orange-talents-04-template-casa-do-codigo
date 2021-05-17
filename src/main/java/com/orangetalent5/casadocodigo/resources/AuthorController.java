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
import com.orangetalent5.casadocodigo.dto.AuthorForm;
import com.orangetalent5.casadocodigo.dto.ResponseAuthorDTO;
import com.orangetalent5.casadocodigo.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorRepository authRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ResponseAuthorDTO> create(@RequestBody @Valid AuthorForm form) {
		Author author = form.toEntity();
		authRepository.save(author);
		ResponseAuthorDTO dto = new ResponseAuthorDTO(author);
		return ResponseEntity.ok().body(dto);
	}
}
