package com.orangetalent5.casadocodigo.resources;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalent5.casadocodigo.domain.Categoria;
import com.orangetalent5.casadocodigo.dto.CategoriaFormDTO;
import com.orangetalent5.casadocodigo.repository.CategoriaRepository;
import com.orangetalent5.casadocodigo.resources.validation.CategoriaValidation;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private CategoriaValidation categoriaValidation;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(categoriaValidation);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@Valid @RequestBody CategoriaFormDTO form) {
		Categoria categoria = form.toEntity();
		categoriaRepo.save(categoria);
		System.out.println(categoria.getId());
		return ResponseEntity.ok().build();
	}

}
