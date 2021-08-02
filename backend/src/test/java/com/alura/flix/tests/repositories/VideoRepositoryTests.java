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
import com.alura.flix.entities.Video;
import com.alura.flix.repositories.VideoRepository;
import com.alura.flix.tests.factory.CategoriaFactory;
import com.alura.flix.tests.factory.VideoFactory;

@DataJpaTest
public class VideoRepositoryTests {
	
	@Autowired
	private VideoRepository repository;
	
	PageRequest pageRequest;
	int qtdeTotalVideos;
	long existingId;
	long nonExistingId;
	Categoria categoria = CategoriaFactory.createCategoria(100L, "Livre", "white");
	Video video = VideoFactory.createVideo(1L, "Título Teste", "Descrição Teste", "http://img.com", categoria);
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 9999087L;
		qtdeTotalVideos = 7;
		pageRequest = PageRequest.of(0,  10);
	}
	
	@Test
	public void findAllShouldReturnAllVideos() {
		
		Page<Video> result = repository.findAll(pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals(qtdeTotalVideos, result.getTotalElements());
	}
	
	@Test
	public void findByIdShouldReturnVideoWhenIdExists() {
		
		Optional<Video> optional = repository.findById(existingId);
		
		Assertions.assertFalse(optional.isEmpty());
	}
	
	@Test
	public void findByIdShouldThrowExceptionWhenIdDoesNotExists() {
		
		Assertions.assertThrows(Exception.class, () -> {
			Optional<Video> optional = repository.findById(nonExistingId);
			@SuppressWarnings("unused")
			Video video = optional.get();
		});
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
		video.setId(null);
		
		video = repository.save(video);
		Optional<Video> result = repository.findById(video.getId());
		
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isPresent());
		Assertions.assertSame(result.get(), video);
	}
	
	@Test
	public void saveShouldThrowExceptionWhenVideoAllreadyExist() {
		
		Assertions.assertThrows(Exception.class, () -> {
			repository.save(video);
		});
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(existingId);
		
		Optional<Video> result = repository.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteByIdShouldReturnEmptyResultDataAccessExceptioWhenIdDoesNotExist() {
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}

}
