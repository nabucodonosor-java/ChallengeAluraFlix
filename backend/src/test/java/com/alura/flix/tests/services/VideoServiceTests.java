package com.alura.flix.tests.services;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alura.flix.dto.VideoDetalhesDto;
import com.alura.flix.entities.Video;
import com.alura.flix.repositories.VideoRepository;
import com.alura.flix.services.VideoService;
import com.alura.flix.services.exceptions.DatabaseException;
import com.alura.flix.services.exceptions.ResourceNotFoundException;
import com.alura.flix.tests.factory.VideoFactory;

@ExtendWith(SpringExtension.class)
public class VideoServiceTests {
	
	@InjectMocks
	private VideoService service;
	
	@Mock
	private VideoRepository repository;
	
	private long existsId;
	private long nonExistsId;
	private long dependentId;
	private PageImpl<Video> page;
	private Video video;
	
	@BeforeEach
	void setUp() {
		existsId = 1L;
		nonExistsId = 2L;
		dependentId = 3L;
		video = VideoFactory.createVideoWithoutCategoria(1L, "Título Teste", "Descrição Teste", "URl teste");
		page = new PageImpl<>(List.of(video));
		
		// qdo chamar findAll retonar uma Page
		when(repository.findAll((PageRequest)ArgumentMatchers.any())).thenReturn(page);
		
		// qdo chamar o save retornar produto
		when(repository.save(ArgumentMatchers.any())).thenReturn(video);
		
		// qdo chamar findById com id existente
		when(repository.findById(existsId)).thenReturn(Optional.of(video));
		
		// qdo chamar findById com id inexistente
		when(repository.findById(nonExistsId)).thenReturn(Optional.empty());
		
		// qdo chamar delete com id existente
		doNothing().when(repository).deleteById(existsId);
		
		// qdo chamar delete com id inexistente
		doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistsId);
		
		// qdo chamar delete para um recurso que ainda está associado a outro
		doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
	}
	
	@Test
	public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findById(nonExistsId);
		});
		
		verify(repository, times(1)).findById(nonExistsId);
	}
	/*
	@Test
	public void findByIdShouldReturnVideoDetalhesDtoWhenIdExists() {
		
		VideoDetalhesDto result = service.findById(existsId);
		
		Assertions.assertNotNull(result);
		
	}
*/
	@Test
	public void deleteByIdShouldThrowDatabaseExceptionWhenDependentId() {
		
		Assertions.assertThrows(DatabaseException.class, () -> {
			service.delete(dependentId);
		});
		
		verify(repository, times(1)).deleteById(dependentId);
	}
	
	@Test
	public void deleteByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.delete(nonExistsId);
		});
		
		verify(repository, times(1)).deleteById(nonExistsId);
	}
	
	@Test
	public void deleteByIdShouldDoNothingWhenIdExists() {
		
		Assertions.assertDoesNotThrow(() -> {
			service.delete(existsId);
		});
		
		verify(repository, Mockito.times(1)).deleteById(existsId);
	}
}
