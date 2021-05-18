package com.orangetalent5.casadocodigo.resources.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.orangetalent5.casadocodigo.dto.AuthorFormDTO;
import com.orangetalent5.casadocodigo.repository.AuthorRepository;

@Component
public class EmailValidation implements Validator {

	@Autowired
	private AuthorRepository authorRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return AuthorFormDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		AuthorFormDTO dto = (AuthorFormDTO) target;
		Boolean ex = authorRepo.existsByEmail(dto.getEmail());
		System.out.println(ex);
		if (ex == true) {
			errors.rejectValue("email", null, "Email já existente");
		}
	}

}
