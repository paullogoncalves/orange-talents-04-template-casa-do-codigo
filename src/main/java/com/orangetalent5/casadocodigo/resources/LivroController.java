package com.orangetalent5.casadocodigo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalent5.casadocodigo.domain.Livro;
import com.orangetalent5.casadocodigo.dto.LivroDetalheResponseDTO;
import com.orangetalent5.casadocodigo.dto.LivroFormDTO;
import com.orangetalent5.casadocodigo.dto.LivroResponseDTO;
import com.orangetalent5.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private EntityManager manager;

	@Autowired
	private LivroRepository livroRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@Valid @RequestBody LivroFormDTO form) {
		Livro livro = form.toEntity(manager);
		livroRepository.save(livro);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<LivroResponseDTO>> findAll() {
		List<Livro> livro = livroRepository.findAll();
		List<LivroResponseDTO> listDto = livro.stream().map(l -> new LivroResponseDTO(l)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroDetalheResponseDTO> findByid(@PathVariable("id") Long id) {
		Optional<Livro> livro = livroRepository.findById(id);

		if (livro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		LivroDetalheResponseDTO livroDetalheResponseDTO = new LivroDetalheResponseDTO(livro.get());

		return ResponseEntity.ok().body(livroDetalheResponseDTO);
	}

}
