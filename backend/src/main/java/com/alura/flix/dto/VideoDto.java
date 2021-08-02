package com.alura.flix.dto;

import java.io.Serializable;

import org.springframework.data.domain.Page;

import com.alura.flix.entities.Video;

public class VideoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long categoriaId;

	private String titulo;

	private String descricao;

	private String url;

	public VideoDto() {
	}

	public VideoDto(Video entity) {
		id = entity.getId();
		categoriaId = entity.getCategoria().getId();
		titulo = entity.getTitulo();
		descricao = entity.getDescricao();
		url = entity.getUrl();
	}

	public VideoDto(Long id, String titulo, String descricao, String url) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
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

	public static Page<VideoDto> converter(Page<Video> listVideos) {
		return listVideos.map(VideoDto::new);
	}

}
