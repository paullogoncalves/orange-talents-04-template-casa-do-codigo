package com.orangetalent5.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalent5.casadocodigo.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
