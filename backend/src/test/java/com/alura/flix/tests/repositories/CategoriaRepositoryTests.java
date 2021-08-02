package com.alura.flix.tests.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.alura.flix.entities.Categoria;
import com.alura.flix.repositories.CategoriaRepository;
import com.alura.flix.tests.factory.CategoriaFactory;

@DataJpaTest
public class CategoriaRepositoryTests {
	
	@Autowired
	private CategoriaRepository repository;
	
	PageRequest pageRequest;
	int qtdeTotalCategorias;
	long existingId;
	long nonExistingId;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 9999087L;
		qtdeTotalCategorias = 4;
		pageRequest = PageRequest.of(0,  10);
	}
	
	@Test
	public void findAllShouldReturnAllCategorias() {
		
		Page<Categoria> result = repository.findAll(pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals(qtdeTotalCategorias, result.getTotalElements());
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
		Categoria categoria = CategoriaFactory.createCategoria(1L, "Livre1", "white1");
		categoria.setId(null);
		
		categoria = repository.save(categoria);
		Optional<Categoria> result = repository.findById(categoria.getId());
		
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isPresent());
		Assertions.assertSame(result.get(), categoria);
	}
	
	@Test
	public void saveShouldThrowSQLExceptionWhenCategoriaAllreadyExist() {
		
		Assertions.assertThrows(Exception.class, () -> {
			Categoria categoria = CategoriaFactory.createCategoria(100L, "Livre", "white");
			repository.save(categoria);
		});
	}
	
	@Test
	public void findByIdShouldReturnCategoriaWhenIdExists() {
		
		Optional<Categoria> optional = repository.findById(existingId);
		
		Assertions.assertFalse(optional.isEmpty());
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(existingId);
		
		Optional<Categoria> result = repository.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteByIdShouldReturnEmptyResultDataAccessExceptioWhenIdDoesNotExist() {
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}

}
