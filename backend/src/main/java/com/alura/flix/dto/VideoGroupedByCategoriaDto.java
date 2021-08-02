package com.alura.flix.dto;

import java.io.Serializable;

import org.springframework.data.domain.Page;

import com.alura.flix.entities.Video;

public class VideoGroupedByCategoriaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String titulo;

	private String descricao;

	private String url;
	
	public VideoGroupedByCategoriaDto() {}
	
	public VideoGroupedByCategoriaDto(Video entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		descricao = entity.getDescricao();
		url = entity.getUrl();
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
	
	public static Page<VideoGroupedByCategoriaDto> converter(Page<Video> listVideos) {
		return listVideos.map(VideoGroupedByCategoriaDto::new);
	}

}
