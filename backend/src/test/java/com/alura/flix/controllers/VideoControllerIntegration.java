package com.alura.flix.controllers;

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

import com.alura.flix.dto.VideoSaveDto;
import com.alura.flix.tests.factory.VideoFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class VideoControllerIntegration {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objMapper;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalVideos;
	private VideoSaveDto videoSaveDtoWithoutCategoria;
	private VideoSaveDto videoSaveDto;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalVideos = 7L;
		
		videoSaveDtoWithoutCategoria = VideoFactory.createVideoSaveDtoWithoutCategoriaAutoIncrementId("Título Teste", "Descrição Teste", "URL Teste");
		
		videoSaveDto = VideoFactory.createVideoSaveDtoAutoIncrementId("Título Teste", "Descrição Teste", "URL Teste", 1L);
	}
	
	@Test
	public void insertWithoutCategoriaShouldReturnVideoSaveDtoWithCategoriaLivre() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(videoSaveDtoWithoutCategoria);
		
		ResultActions result = mockMvc.perform(post("/videos")
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.categoriaId").value(1L));
	}
	
	@Test
	public void findAllShouldReturnSortedPageWhenSortByTitutlo() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/videos?page=0&size=12&sort=titulo&direction=ASC")
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.totalElements").value(countTotalVideos));
		result.andExpect(jsonPath("$.content").exists());
		result.andExpect(jsonPath("$.content[0].titulo").value("A Guerra Franco-Prussiana"));
		result.andExpect(jsonPath("$.content[1].titulo").value("As 7 Maravilhas - Mundo Antigo"));
		result.andExpect(jsonPath("$.content[2].titulo").value("Atlanta 1996 - Prata G. Borges"));
	}
	
	@Test
	public void updateShouldReturnVideoSaveDtoWhenIdExists() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(videoSaveDto);
		
		String expectedTitutlo = videoSaveDto.getTitulo();
		
		ResultActions result = mockMvc.perform(put("/videos/{id}", existingId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").value(existingId));
		result.andExpect(jsonPath("$.titulo").value(expectedTitutlo));
	}
	
	@Test
	public void updateShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		
		String jsonBody = objMapper.writeValueAsString(videoSaveDto);
		
		ResultActions result = mockMvc.perform(put("/videos/{id}", nonExistingId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}

}
