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

import com.orangetalent5.casadocodigo.domain.Cliente;
import com.orangetalent5.casadocodigo.dto.ClienteFormDTO;
import com.orangetalent5.casadocodigo.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private EntityManager manager;

	@Autowired
	private ClienteRepository clienteRepository;

	
	@PostMapping
	@Transactional
	public ResponseEntity<Long> create(@Valid @RequestBody ClienteFormDTO form) {
		Cliente cliente = form.toEntity(manager);
		clienteRepository.save(cliente);
		Long id = cliente.getId();
		return ResponseEntity.ok().body(id);
	}
	
	
	
}
