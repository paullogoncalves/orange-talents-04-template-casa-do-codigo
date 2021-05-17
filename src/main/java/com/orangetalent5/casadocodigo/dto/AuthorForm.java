package com.orangetalent5.casadocodigo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.orangetalent5.casadocodigo.domain.Author;

public class AuthorForm {
	private Long id;

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@NotEmpty
	@Length(max = 400)
	private String descricao;

	public AuthorForm() {
	}

	public AuthorForm(Long id, @NotNull @NotEmpty String nome, @NotNull @NotEmpty @Email String email,
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
