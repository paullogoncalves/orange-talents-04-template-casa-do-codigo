package com.orangetalent5.casadocodigo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String titulo;
	@NotBlank
	private String resumo;
	@NotBlank
	private String sumario;
    @Min(20)
    @NotNull
	private BigDecimal preco;
	@Min(100)
	private Integer numerosPaginas;
	@Column(unique = true)
	private String isbn;
	@NotNull
	private LocalDate dataPublicacao;
	

	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Author author;
	
	public Livro() {
	}

	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numerosPaginas, String isbn,
			LocalDate dataPublicacao, Categoria categoria, Author author) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numerosPaginas = numerosPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumerosPaginas() {
		return numerosPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}


}
