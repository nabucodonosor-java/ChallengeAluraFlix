package com.alura.flix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;

import com.alura.flix.entities.Categoria;
import com.alura.flix.entities.Video;

public class CategoriaWithVideoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "O campo é obrigatório")
	private String titulo;

	@NotBlank(message = "O campo é obrigatório")
	private String cor;
	
	List<VideoDto> videos = new ArrayList<>();
	
	public CategoriaWithVideoDto() {}
	
	public CategoriaWithVideoDto(Categoria entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		cor = entity.getCor();
	}

	public CategoriaWithVideoDto(Categoria entity, List<Video> videos) {
		this(entity);
		videos.forEach(video -> this.getVideos().add(new VideoDto(video)));
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
	
	public List<VideoDto> getVideos() {
		return videos;
	}

	public static Page<CategoriaDto> converter(Page<Categoria> page) {
		return page.map(CategoriaDto::new);
	}

}
