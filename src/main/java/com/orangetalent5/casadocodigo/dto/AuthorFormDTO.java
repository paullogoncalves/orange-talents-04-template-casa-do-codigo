package com.orangetalent5.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.orangetalent5.casadocodigo.domain.Author;
import com.orangetalent5.casadocodigo.resources.validation.UniqueValue;


public class AuthorFormDTO {
	private Long id;

	@NotNull
	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	@NotNull
	@NotEmpty
	@Email(message = "Preenchimento obrigatório")
	@UniqueValue(domainClass = Author.class, fieldName = "email")
	private String email;

	@NotNull
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(max = 400)
	private String descricao;

	public AuthorFormDTO() {
	}

	public AuthorFormDTO(Long id, @NotNull @NotEmpty String nome, @NotNull @NotEmpty @Email String email,
			@NotNull @NotEmpty @Length(max = 400) String descricao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Author toEntity() {
		return new Author(this.id, this.nome, this.email, this.descricao);
	}
}
