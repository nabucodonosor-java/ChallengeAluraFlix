package com.alura.flix.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alura.flix.dto.CategoriaDto;
import com.alura.flix.dto.CategoriaWithVideoDto;
import com.alura.flix.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<Page<CategoriaDto>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction,
			@RequestParam(value = "sort", defaultValue = "id") String sort) {

		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), sort);
		Page<CategoriaDto> list = service.findAllPaged(pageRequest);

		return ResponseEntity.ok().body(list);

	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> findById(@PathVariable Long id) {
		CategoriaDto entity = service.findById(id);
		return ResponseEntity.ok().body(entity);
	}
	
	@GetMapping("/{id}/videos")
	public ResponseEntity<CategoriaWithVideoDto> findCategoriaWithVideos(@PathVariable Long id) {
		CategoriaWithVideoDto entity = service.findCategoriaWithVideos(id);
		return ResponseEntity.ok().body(entity);
	}

	@PostMapping
	public ResponseEntity<CategoriaDto> insert(@Valid @RequestBody CategoriaDto dto) {
		dto = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDto> update(@PathVariable Long id, @Valid @RequestBody CategoriaDto dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}