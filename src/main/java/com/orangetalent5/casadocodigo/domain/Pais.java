package com.orangetalent5.casadocodigo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotBlank(message = "Campo obrogatório")
	private String nome;

	@OneToMany(mappedBy = "pais")
	private List<Estado> estado = new ArrayList<>();

	public Pais() {

	}

	public Pais(@NotBlank(message = "Campo obrogatório") String nome) {
		this.nome = nome;

	}

}
