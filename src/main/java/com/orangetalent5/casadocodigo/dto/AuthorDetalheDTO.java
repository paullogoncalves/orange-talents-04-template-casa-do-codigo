package com.orangetalent5.casadocodigo.dto;

import com.orangetalent5.casadocodigo.domain.Author;

public class AuthorDetalheDTO {
	
	private String nome;
	private String descricao;

	public AuthorDetalheDTO(Author author) {
		nome = author.getNome();
		descricao = author.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
