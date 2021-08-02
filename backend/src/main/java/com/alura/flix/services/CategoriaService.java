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

import com.alura.flix.dto.CategoriaDto;
import com.alura.flix.entities.Categoria;
import com.alura.flix.repositories.CategoriaRepository;
import com.alura.flix.services.exceptions.DatabaseException;
import com.alura.flix.services.exceptions.ResourceNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Transactional(readOnly = true)
	public Page<CategoriaDto> findAllPaged(PageRequest pageRequest) {
		Page<Categoria> page = repository.findAll(pageRequest);
		return CategoriaDto.converter(page);
	}

	@Transactional(readOnly = true)
	public CategoriaDto findById(Long id) {
		Optional<Categoria> optional = repository.findById(id);
		return new CategoriaDto(optional.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada!")));
	}

	@Transactional
	public CategoriaDto save(CategoriaDto dto) {
			
		Categoria entity = new Categoria();
		copyToEntity(entity, dto);
		entity = repository.save(entity);
		return new CategoriaDto(entity);
		
	}

	@Transactional
	public CategoriaDto update(Long id, CategoriaDto dto) {
		try {
			
			Optional<Categoria> optional = repository.findById(id);
			Categoria entity = optional.get();
			copyToEntity(entity, dto);
			entity = repository.save(entity);
			return new CategoriaDto(entity);
			
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Categoria não encontrada!");
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Categoria não encontrada!");
		}
	}
	
	public void delete(Long id) {
		try {

			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Categoria não encontrada!");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação no DB");
		}
	}

	private void copyToEntity(Categoria entity, CategoriaDto dto) {

		entity.setTitulo(dto.getTitulo());
		entity.setCor(dto.getCor());
	}

}
