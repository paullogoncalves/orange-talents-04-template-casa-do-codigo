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

import com.orangetalent5.casadocodigo.domain.Estado;
import com.orangetalent5.casadocodigo.dto.EstadoFormDTO;
import com.orangetalent5.casadocodigo.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EntityManager manager;

	@Autowired
	private EstadoRepository estadoRepository;

	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@Valid @RequestBody EstadoFormDTO form) {
		Estado estado = form.toEntity(manager);
		estadoRepository.save(estado);

		return ResponseEntity.ok().build();
	}
	
	
	
}
