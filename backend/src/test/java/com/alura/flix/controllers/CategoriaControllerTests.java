package com.alura.flix.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.alura.flix.dto.CategoriaDto;
import com.alura.flix.services.CategoriaService;
import com.alura.flix.services.exceptions.DatabaseException;
import com.alura.flix.services.exceptions.ResourceNotFoundException;
import com.alura.flix.tests.factory.CategoriaFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objMapper;
	
	@MockBean
	private CategoriaService service;
	
	private PageImpl<CategoriaDto> page;
	private CategoriaDto categoriaDto;
	private long existsId;
	private long nonExistsId;

	private Long dependentId;
	
	@BeforeEach
	void setUp() {
		
		existsId = 1L;
		nonExistsId = 2L;
		dependentId = 3L;
		
		categoriaDto = CategoriaFactory.createCategoriaDto(1L, "Título Teste", "Cor Teste");
		
		page = new PageImpl<>(List.of(categoriaDto));
		
		when(service.findAllPaged(ArgumentMatchers.any())).thenReturn(page);
		
		when(service.findById(existsId)).thenReturn(categoriaDto);
		
		when(service.findById(nonExistsId)).thenThrow(ResourceNotFoundException.class);
		
		when(service.save(ArgumentMatchers.any())).thenReturn(categoriaDto);
		
		when(service.update(Mockito.eq(existsId), ArgumentMatchers.any())).thenReturn(categoriaDto);
		
		when(service.update(Mockito.eq(nonExistsId), ArgumentMatchers.any())).thenThrow(ResourceNotFoundException.class);
		
		doNothing().when(service).delete(existsId);
		
		doThrow(ResourceNotFoundException.class).when(service).delete(nonExistsId);
		
		doThrow(DatabaseException.class).when(service).delete(dependentId);
		
		
	}
	
	@Test
	public void deleteShouldReturnNoContentWhenIdExists() throws Exception {
		
		ResultActions result = mockMvc.perform(delete("/categorias/{id}", existsId)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNoContent());
	}
	
	@Test
	public void deleteShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		
		ResultActions result = mockMvc.perform(delete("/categorias/{id}", nonExistsId)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
		
	}
	
	@Test
	public void insertSHouldReturnVideoSaveDtoCreated() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(categoriaDto);
		
		ResultActions result = mockMvc.perform(post("/categorias")
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").exists());
	}
	
	@Test
	public void updateShouldReturnVIdeoSaveDtoWhenIdExists() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(categoriaDto);
		
		ResultActions result = mockMvc.perform(put("/categorias/{id}", existsId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		
	}
	
	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(categoriaDto);
		
		ResultActions result = mockMvc.perform(put("/categorias/{id}", nonExistsId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	@Test
	public void findAllShouldReturnPage() throws Exception {
		mockMvc.perform(get("/categorias")).andExpect(status().isOk());
	}
	
	@Test
	public void findByIdShouldReturnVideoDtoWhenIdExists() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/categorias/{id}", existsId).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
	}
	
	@Test
	public void findByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/categorias/{id}", nonExistsId).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}

}
