package com.orangetalent5.casadocodigo.resources.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.orangetalent5.casadocodigo.domain.Categoria;
import com.orangetalent5.casadocodigo.dto.CategoriaFormDTO;
import com.orangetalent5.casadocodigo.repository.CategoriaRepository;

@Component
public class CategoriaValidation implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return CategoriaFormDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		CategoriaFormDTO dto = (CategoriaFormDTO) target;
		Optional<Categoria> ex = categoriaRepo.findByNome(dto.getNome());
		if (ex.isPresent()) {
			errors.rejectValue("nome", null, "categoria já existente");
		}
	}

}
