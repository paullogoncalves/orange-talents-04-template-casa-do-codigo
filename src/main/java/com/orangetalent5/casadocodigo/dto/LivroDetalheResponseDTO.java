package com.orangetalent5.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import com.orangetalent5.casadocodigo.domain.Author;
import com.orangetalent5.casadocodigo.domain.Livro;

public class LivroDetalheResponseDTO {

	private String titulo;
	private AuthorDetalheDTO autor;
	private String isbn;
	private BigDecimal preco;
	private Integer numerosPaginas;
	private String resumo;
	private String sumario;
	private String dataPublicacao;

	public LivroDetalheResponseDTO(Livro livro) {
		titulo = livro.getTitulo();
		setAutor(new AuthorDetalheDTO(livro.getAuthor()));
		isbn = livro.getIsbn();
		preco = livro.getPreco();
		numerosPaginas = livro.getNumerosPaginas();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		setDataPublicacao(livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getNumerosPaginas() {
		return numerosPaginas;
	}

	public void setNumerosPaginas(Integer numerosPaginas) {
		this.numerosPaginas = numerosPaginas;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public AuthorDetalheDTO getAutor() {
		return autor;
	}

	public void setAutor(AuthorDetalheDTO autor) {
		this.autor = autor;
	}
	
	
}
