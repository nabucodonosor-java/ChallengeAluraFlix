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

import com.alura.flix.dto.VideoDto;
import com.alura.flix.repositories.VideoRepository;
import com.alura.flix.services.VideoService;
import com.alura.flix.services.exceptions.ResourceNotFoundException;

@SpringBootTest
@Transactional
public class CategoriaServiceIntegration {
	
	@Autowired
	private VideoService service;
	
	@Autowired
	private VideoRepository repository;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalVideos;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalVideos = 7L;
	}
	
	@Test
	public void deleteShouldDeleteVideoWhenIdExists() {
		
		service.delete(existingId);
		
		Assertions.assertEquals(countTotalVideos - 1, repository.count());
		
	}
	
	@Test
	public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.delete(nonExistingId);
		});
		
		Assertions.assertEquals(countTotalVideos, repository.count());
		
	}
	
	@Test
	public void findAllShouldReturnPageWhenPage0Size10() {
		
		PageRequest pageRequest = PageRequest.of(0, 10);
		
		Page<VideoDto> result = service.findAll(pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals(0, result.getNumber());
		Assertions.assertEquals(10, result.getSize());
		Assertions.assertEquals(countTotalVideos, result.getTotalElements());
	}
	
	@Test
	public void findAllShouldReturnEmptyPageWhenPageDoesNotExist() {
		
		PageRequest pageRequest = PageRequest.of(50, 10);
		
		Page<VideoDto> result = service.findAll(pageRequest);
		
		Assertions.assertTrue(result.isEmpty());

	}
	
	@Test
	public void findAllShouldReturnOrderedPageWhenSortByTitulo() {
		
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("titulo"));
		
		Page<VideoDto> result = service.findAll(pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals("A Guerra Franco-Prussiana", result.getContent().get(0).getTitulo());
		Assertions.assertEquals("As 7 Maravilhas - Mundo Antigo", result.getContent().get(1).getTitulo());
		Assertions.assertEquals("Atlanta 1996 - Prata G. Borges", result.getContent().get(2).getTitulo());

	}

}
