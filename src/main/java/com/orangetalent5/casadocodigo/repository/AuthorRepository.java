package com.orangetalent5.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.orangetalent5.casadocodigo.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Transactional(readOnly = true)
	Author findByEmail(String email);
	
	@Transactional(readOnly = true)
	Boolean existsByEmail(String email);
}
