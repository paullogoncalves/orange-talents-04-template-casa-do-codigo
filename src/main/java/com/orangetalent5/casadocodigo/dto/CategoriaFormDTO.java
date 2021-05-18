package com.orangetalent5.casadocodigo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.orangetalent5.casadocodigo.domain.Categoria;
import com.orangetalent5.casadocodigo.resources.validation.UniqueValue;

public class CategoriaFormDTO {

	private Long id;

	@NotNull
	@NotEmpty(message = "Preenchimento obrigatório")
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public CategoriaFormDTO() {

	}

	public CategoriaFormDTO(Long id, @NotNull @NotEmpty String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria toEntity() {
		return new Categoria(this.id, this.nome);
	}

}
