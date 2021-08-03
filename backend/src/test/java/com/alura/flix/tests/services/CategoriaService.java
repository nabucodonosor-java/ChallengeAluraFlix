package com.alura.flix.tests.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alura.flix.repositories.CategoriaRepository;


@ExtendWith(SpringExtension.class)
public class CategoriaService {
	
	@InjectMocks
	private CategoriaService service;
	
	@Mock
	private CategoriaRepository repository;
	
	@Test
	public void deleteByIdShouldWhenIdExists() {
		
		
	}
}
