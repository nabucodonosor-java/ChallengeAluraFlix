package com.alura.flix.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.alura.flix.dto.CategoriaDto;
import com.alura.flix.tests.factory.CategoriaFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CategoriaControllerIntegration {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objMapper;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalCategorias;
	private CategoriaDto categoriaDto;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalCategorias = 5L;
		
		categoriaDto = CategoriaFactory.createCategoriaDtoAutoIncrementId("Teste Controllers", "controllers");
		
	}
	
	@Test
	public void findAllShouldReturnSortedPageWhenSortByTitutlo() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/categorias?page=0&size=12&sort=titulo&direction=ASC")
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.totalElements").value(countTotalCategorias));
		result.andExpect(jsonPath("$.content").exists());
		result.andExpect(jsonPath("$.content[0].titulo").value("DOCUMENTÁRIOS"));
		result.andExpect(jsonPath("$.content[1].titulo").value("ESPORTES"));
		result.andExpect(jsonPath("$.content[2].titulo").value("LIVRE"));
	}
	
	@Test
	public void findByIdShouldReturnIsOkWhenIdExists() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/categorias/{id}", existingId)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	public void insertShouldReturnCreated() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(categoriaDto);
		
		ResultActions result = mockMvc.perform(post("/categorias")
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
	}
	
	@Test
	public void updateShouldReturnVideoSaveDtoWhenIdExists() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(categoriaDto);
		
		String expectedTitutlo = categoriaDto.getTitulo();
		
		ResultActions result = mockMvc.perform(put("/categorias/{id}", existingId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").value(existingId));
		result.andExpect(jsonPath("$.titulo").value(expectedTitutlo));
	}
	
	@Test
	public void updateShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(categoriaDto);
		
		ResultActions result = mockMvc.perform(put("/categorias/{id}", nonExistingId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	@Test
	public void deleteShouldReturnNoContentWhenIdExists() throws Exception {
		
		ResultActions result = mockMvc.perform(delete("/categorias/{id}", existingId)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNoContent());
	}

}
