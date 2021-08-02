package com.alura.flix.dto;

import java.io.Serializable;

import org.springframework.data.domain.Page;

import com.alura.flix.entities.Video;

public class VideoDetalhesDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String titulo;

	private String descricao;

	private String url;
	
	private Long categoriaId;
	
	private String tituloCategoria;
	
	private String corCategoria;
	
	public VideoDetalhesDto() {}
	
	public VideoDetalhesDto(Video entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		descricao = entity.getDescricao();
		url = entity.getUrl();
		categoriaId = entity.getCategoria().getId();
		tituloCategoria = entity.getCategoria().getTitulo();
		corCategoria = entity.getCategoria().getCor();
	}
	
	public String getTituloCategoria() {
		return tituloCategoria;
	}

	public void setTituloCategoria(String tituloCategoria) {
		this.tituloCategoria = tituloCategoria;
	}

	public String getCorCategoria() {
		return corCategoria;
	}

	public void setCorCategoria(String corCategoria) {
		this.corCategoria = corCategoria;
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
	
	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public static Page<VideoDetalhesDto> converter(Page<Video> listVideos) {
		return listVideos.map(VideoDetalhesDto::new);
	}

}
