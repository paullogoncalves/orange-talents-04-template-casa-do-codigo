package com.orangetalent5.casadocodigo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@Column(unique = true)
	private String documento;// (cpf/cnpj)
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;

	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado; // (caso aquele pais tenha estado)
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			Pais pais, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Long getId() {
		return id;
	}

}
