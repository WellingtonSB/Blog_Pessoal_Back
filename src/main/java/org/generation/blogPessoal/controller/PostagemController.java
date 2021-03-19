package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;
	// instancia tudo o que está na interface PostagemRepository ao utilizar o
	// @autowired

	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(postagemRepository.findAll());
		// ResponseEntity: significa representar toda a resposta HTTP. Você pode
		// controlar qualquer coisa que aconteça: código de status, cabeçalhos e corpo.
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id) {
		return postagemRepository.findById(id).map(resp -> ResponseEntity.ok(resp))

				.orElse(ResponseEntity.notFound().build());
		// PathVariable: é utilizado quando o valor da variável é passada diretamente na
		// URL

	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
		// Parecido com o like %n%

	}

	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
		// Inserir dados na body/postman

	}

	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		// modificar dados na body/postman
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		postagemRepository.deleteById(id);
	}
}