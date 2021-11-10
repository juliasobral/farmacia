package com.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.model.Categoria;
import com.farmacia.repository.CategoriaFarmaciaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaFarmaciaController {

	@Autowired
	private CategoriaFarmaciaRepository categoriaFarmaciaRepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(categoriaFarmaciaRepository.findAll());
	}

	@GetMapping("/{idCategoria}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id_categoria) {
		return categoriaFarmaciaRepository.findById(id_categoria).map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<Categoria>> GetByTipoProduto(@PathVariable String marca) {
		return ResponseEntity.ok(categoriaFarmaciaRepository.findAllByMarca(marca));
	}

	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria obj) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaFarmaciaRepository.save(obj));
	}

	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria obj) {
		return ResponseEntity.status(HttpStatus.OK).body(this.categoriaFarmaciaRepository.save(obj));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		this.categoriaFarmaciaRepository.deleteById(id);
	}
}
