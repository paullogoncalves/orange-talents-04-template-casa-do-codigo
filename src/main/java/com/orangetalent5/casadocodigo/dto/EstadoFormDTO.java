package com.orangetalent5.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.orangetalent5.casadocodigo.domain.Estado;
import com.orangetalent5.casadocodigo.domain.Pais;
import com.orangetalent5.casadocodigo.resources.validation.UniqueValue;

public class EstadoFormDTO {

	@NotBlank(message = "Campo obrogatório")
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	@NotNull
	private Long idPais;

	public EstadoFormDTO(@NotBlank(message = "Campo obrogatório") String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toEntity(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		return new Estado(nome, pais);
	}
}
