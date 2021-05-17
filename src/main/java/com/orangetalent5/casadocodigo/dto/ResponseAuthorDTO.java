package com.orangetalent5.casadocodigo.dto;

import java.time.LocalDateTime;

import com.orangetalent5.casadocodigo.domain.Author;

public class ResponseAuthorDTO {

	private Long id;
	
	private String nome;

	private String email;

	private String descricao;
	
	private LocalDateTime instante;

	
	public ResponseAuthorDTO() {

	}

	public ResponseAuthorDTO(Author obj) {
		id = obj.getId();
		nome= obj.getNome();
		email = obj.getEmail();
		descricao = obj.getDescricao();
		instante = obj.getInstanteRegistro();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInstante() {
		return instante;
	}
	
}
