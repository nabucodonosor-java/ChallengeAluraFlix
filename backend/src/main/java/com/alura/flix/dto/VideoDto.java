package com.alura.flix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Page;

import com.alura.flix.entities.Video;

public class VideoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo obrigatório!")
	@Size(max = 30, message = "Título deve ter no máximo 30 caracteres")
	private String titulo;

	@NotBlank(message = "Campo obrigatório!")
	private String descricao;

	@NotBlank(message = "Campo obrigatório!")
	private String url;
	
	private CategoriaDto categoria;
	
	public VideoDto() {}
	
	public VideoDto(Video entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		descricao = entity.getDescricao();
		url = entity.getUrl();
		categoria = new CategoriaDto(entity.getCategoria());
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public CategoriaDto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}

	public static Page<VideoDto> converter(Page<Video> listVideos) {
		return listVideos.map(VideoDto::new);
	}

}
