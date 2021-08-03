package com.alura.flix.dto;

import java.io.Serializable;

import com.alura.flix.entities.Video;

public class VideoDetalhesDto extends VideoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tituloCategoria;
	private String corCategoria;

	public VideoDetalhesDto() {
	}

	public VideoDetalhesDto(String tituloCategoria, String corCategoria) {
		super();
		this.tituloCategoria = tituloCategoria;
		this.corCategoria = corCategoria;
	}

	public VideoDetalhesDto(Video entity) {
		super(entity);
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

}
