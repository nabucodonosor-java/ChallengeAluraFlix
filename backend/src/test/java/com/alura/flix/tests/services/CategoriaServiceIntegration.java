package com.alura.flix.tests.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.alura.flix.dto.CategoriaDto;
import com.alura.flix.repositories.CategoriaRepository;
import com.alura.flix.services.CategoriaService;
import com.alura.flix.services.exceptions.ResourceNotFoundException;

@SpringBootTest
@Transactional
public class CategoriaServiceIntegration {
	
	@Autowired
	private CategoriaService service;
	
	@Autowired
	private CategoriaRepository repository;
	
	private long deleteId;
	private long nonExistingId;
	private long countTotalCategorias;
	
	@BeforeEach
	void setUp() throws Exception {
		deleteId = 5L;
		nonExistingId = 1000L;
		countTotalCategorias = 5L;
	}
	
	@Test
	public void deleteShouldDeleteCategoriaWhenIdExists() {
		
		service.delete(deleteId);
		
		Assertions.assertEquals(countTotalCategorias - 1, repository.count());
		
	}
	
	@Test
	public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.delete(nonExistingId);
		});
		
		Assertions.assertEquals(countTotalCategorias, repository.count());
		
	}
	
	@Test
	public void findAllShouldReturnPageWhenPage0Size10() {
		
		PageRequest pageRequest = PageRequest.of(0, 10);
		
		Page<CategoriaDto> result = service.findAllPaged(pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals(0, result.getNumber());
		Assertions.assertEquals(10, result.getSize());
		Assertions.assertEquals(countTotalCategorias, result.getTotalElements());
	}
	
	@Test
	public void findAllShouldReturnEmptyPageWhenPageDoesNotExist() {
		
		PageRequest pageRequest = PageRequest.of(50, 10);
		
		Page<CategoriaDto> result = service.findAllPaged(pageRequest);
		
		Assertions.assertTrue(result.isEmpty());

	}
	
	@Test
	public void findAllShouldReturnOrderedPageWhenSortByTitulo() {
		
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("titulo"));
		
		Page<CategoriaDto> result = service.findAllPaged(pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals("DOCUMENTÁRIOS", result.getContent().get(0).getTitulo());
		Assertions.assertEquals("ESPORTES", result.getContent().get(1).getTitulo());
		Assertions.assertEquals("LIVRE", result.getContent().get(2).getTitulo());

	}

}
