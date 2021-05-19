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

import com.orangetalent5.casadocodigo.domain.Pais;
import com.orangetalent5.casadocodigo.dto.PaisFormDTO;
import com.orangetalent5.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	private EntityManager manager;

	@Autowired
	private PaisRepository paisRepository;

	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@Valid @RequestBody PaisFormDTO form) {
		Pais pais = form.toEntity();
		paisRepository.save(pais);

		return ResponseEntity.ok().build();
	}
	
	
	
}
