package com.alura.flix.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alura.flix.dto.VideoDto;
import com.alura.flix.dto.VideoSaveDto;
import com.alura.flix.entities.Categoria;
import com.alura.flix.entities.Video;
import com.alura.flix.repositories.CategoriaRepository;
import com.alura.flix.repositories.VideoRepository;
import com.alura.flix.services.exceptions.DatabaseException;
import com.alura.flix.services.exceptions.ResourceNotFoundException;

@Service
public class VideoService {

	@Autowired
	private VideoRepository repository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional(readOnly = true)
	public Page<VideoDto> findAll(PageRequest pageRequest) {
		Page<Video> listVideos = repository.findAll(pageRequest);
		return VideoDto.converter(listVideos);
	}

	@Transactional(readOnly = true)
	public VideoDto findById(Long id) {
		Optional<Video> optional = repository.findById(id);
		return new VideoDto(optional.orElseThrow(() -> new ResourceNotFoundException("Vídeo não encontrado!")));
	}
	
	@Transactional(readOnly = true)
	public Page<VideoDto> findByNome(PageRequest pageRequest, String titulo) {
		Page<Video> page = repository.findVideoByTitulo(titulo, pageRequest);
		return page.map(VideoDto::new);
	}

	@Transactional
	public VideoSaveDto insert(VideoSaveDto dto) {

		Video entity = new Video();
		copyToEntity(entity, dto);
		entity = repository.save(entity);
		return new VideoSaveDto(entity);
	}

	@Transactional
	public VideoSaveDto update(Long id, VideoSaveDto dto) {
		try {
			Optional<Video> optional = repository.findById(id);
			Video entity = optional.get();
			copyToEntity(entity, dto);
			entity = repository.save(entity);
			return new VideoSaveDto(entity);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Vídeo não encontrado!");
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Vídeo não encontrado!");
		}
	}

	public void delete(Long id) {
		try {

			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Vídeo não encontrado!");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação no DB");
		}
	}

	private void copyToEntity(Video entity, VideoSaveDto dto) {

		entity.setTitulo(dto.getTitulo());
		entity.setDescricao(dto.getDescricao());
		entity.setUrl(dto.getUrl());

		if (dto.getCategoriaId() == null) {
			
			entity.setCategoria(new Categoria(1L, "LIVRE", "white"));
			
		} else {
			
		Categoria categoria = categoriaRepository.getOne(dto.getCategoriaId());
		entity.setCategoria(categoria);
		
		}
	}
}
