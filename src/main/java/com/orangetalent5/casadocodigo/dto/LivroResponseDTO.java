package com.orangetalent5.casadocodigo.dto;

import com.orangetalent5.casadocodigo.domain.Livro;

public class LivroResponseDTO {

	private Long id;
	private String titulo;
	
	public LivroResponseDTO(Livro livro) {
		id = livro.getId();
		titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
