package com.alura.flix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;

import com.alura.flix.entities.Categoria;

public class CategoriaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "O campo é obrigatório")
	private String titulo;

	@NotBlank(message = "O campo é obrigatório")
	private String cor;
	
	public CategoriaDto() {}
	
	public CategoriaDto(Categoria entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		cor = entity.getCor();
	}

	public CategoriaDto(Long id, String titulo, String cor) {
		this.id = id;
		this.titulo = titulo;
		this.cor = cor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public static Page<CategoriaDto> converter(Page<Categoria> page) {
		return page.map(CategoriaDto::new);
	}

}
