package com.orangetalent5.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.orangetalent5.casadocodigo.domain.Cliente;
import com.orangetalent5.casadocodigo.domain.Estado;
import com.orangetalent5.casadocodigo.domain.Pais;
import com.orangetalent5.casadocodigo.resources.validation.CPFOrCNPJ;
import com.orangetalent5.casadocodigo.resources.validation.UniqueValue;

public class ClienteFormDTO {
	
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank(message = "Nome obrigatório")
	private String nome;
	@NotBlank(message = "Sobre nome obrigatório")
	private String sobrenome;
	
	@CPFOrCNPJ(domainClass = Cliente.class, fieldName = "documento")
	@NotBlank(message = "Documento obrigatório")
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank(message = "Endereco obrigatório")
	private String endereco;
	
	private String complemento;
	@NotBlank(message = "Cidade obrigatório")
	private String cidade;
	@NotNull
	private Long pais_id;
	private Long estado_id; 	
	@NotBlank(message = "Telefone obrigatório")
	private String telefone;
	@NotBlank(message = "Cep obrigatório")
	private String cep;
	
	
	public ClienteFormDTO() {
		
	}
	
	public ClienteFormDTO(String email, @NotBlank(message = "Nome obrigatório") String nome,
			@NotBlank(message = "Sobre nome obrigatório") String sobrenome,
			@NotBlank(message = "Documento obrigatório") String documento,
			@NotBlank(message = "Endereco obrigatório") String endereco, String complemento,
			@NotBlank(message = "Cidade obrigatório") String cidade, @NotNull Long pais_id, Long estado_id,
			@NotBlank(message = "Telefone obrigatório") String telefone,
			@NotBlank(message = "Cep obrigatório") String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais_id = pais_id;
		this.estado_id = estado_id;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	
	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPais_id() {
		return pais_id;
	}

	public Long getEstado_id() {
		return estado_id;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Cliente toEntity(EntityManager manager) {
		Pais pais = manager.find(Pais.class, pais_id);
		Estado estado = manager.find(Estado.class, estado_id);
		return new Cliente(email, nome, sobrenome, documento, endereco, 
				complemento, cidade, pais, telefone, cep);
	}
}


