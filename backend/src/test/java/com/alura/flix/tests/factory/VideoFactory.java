package com.alura.flix.tests.factory;

import com.alura.flix.dto.VideoDetalhesDto;
import com.alura.flix.entities.Categoria;
import com.alura.flix.entities.Video;

public class VideoFactory {
	
	public static Video createVideo(Long id, String titulo, String descricao, String url, Categoria categoria) {
		return new Video(id, titulo, descricao, url, categoria);
	}
	
	public static Video createVideoWithoutCategoria(Long id, String titulo, String descricao, String url) {
		return new Video(id, titulo, descricao, url);
	}
	
	public static VideoDetalhesDto createVideoDetalhesDto(Long id, String titulo, String descricao, String url, 
			Long categoriaId, String tituloCategoria, String corCategoria) {
		return new VideoDetalhesDto(id, titulo, descricao, url, categoriaId, tituloCategoria, corCategoria);
	}
	
}
