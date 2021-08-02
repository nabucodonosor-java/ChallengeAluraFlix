package com.alura.flix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Page;

import com.alura.flix.entities.Video;

public class VideoSaveDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "O campo é obrigatório")
	@Size(max = 30, message = "Título deve ter no máximo 30 caracteres")
	private String titulo;

	@NotBlank(message = "O campo é obrigatório")
	private String descricao;

	@NotBlank(message = "O campo é obrigatório")
	private String url;

	private Long categoriaId;

	public VideoSaveDto() {
	}

	public VideoSaveDto(Video entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		descricao = entity.getDescricao();
		url = entity.getUrl();
		categoriaId = entity.getCategoria().getId();
	}

	public VideoSaveDto(Long id, String titulo,  String descricao, String url, Long categoriaId) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public static Page<VideoSaveDto> converter(Page<Video> listVideos) {
		return listVideos.map(VideoSaveDto::new);
	}

}
