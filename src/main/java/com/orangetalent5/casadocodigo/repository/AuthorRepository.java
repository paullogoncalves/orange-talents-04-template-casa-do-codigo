package com.orangetalent5.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalent5.casadocodigo.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
