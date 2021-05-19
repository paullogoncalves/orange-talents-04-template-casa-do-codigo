package com.orangetalent5.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalent5.casadocodigo.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
