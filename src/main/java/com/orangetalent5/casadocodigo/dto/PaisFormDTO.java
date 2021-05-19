package com.orangetalent5.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import com.orangetalent5.casadocodigo.domain.Pais;
import com.orangetalent5.casadocodigo.repository.PaisRepository;
import com.orangetalent5.casadocodigo.resources.validation.UniqueValue;

public class PaisFormDTO {

	@NotBlank(message = "Campo obrogatório")
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public PaisFormDTO() {
		// TODO Auto-generated constructor stub
	}
	public PaisFormDTO(@NotBlank(message = "Campo obrogatório") String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Pais toEntity() {
		return new Pais(nome);
	}

}
