package com.orangetalent5.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.orangetalent5.casadocodigo.domain.Author;
import com.orangetalent5.casadocodigo.domain.Categoria;
import com.orangetalent5.casadocodigo.domain.Livro;
import com.orangetalent5.casadocodigo.resources.validation.UniqueValue;

public class LivroFormDTO {

	@NotBlank(message = "Preenchimento obrigatório")
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank(message = "Preenchimento obrigatório")
	@Length(max = 500)
	private String resumo;
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@Min(100)
	private Integer numerosPaginas;
	@NotBlank(message = "Preenchimento obrigatório")
	// @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	private Long idCategoria;
	@NotNull
	private Long idAutor;

	public LivroFormDTO(@NotBlank(message = "Preenchimento obrigatório") String titulo,
			@NotBlank(message = "Preenchimento obrigatório") @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) Integer numerosPaginas,
			@NotBlank(message = "Preenchimento obrigatório") String isbn, @NotBlank Long idCategoria,
			@NotBlank Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numerosPaginas = numerosPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toEntity(EntityManager manager) {
		Author author = manager.find(Author.class, idAutor);
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		return new Livro(titulo, resumo, sumario, preco, numerosPaginas, isbn, dataPublicacao, categoria, author);
	}

}
