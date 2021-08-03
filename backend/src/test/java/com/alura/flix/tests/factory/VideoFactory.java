package com.alura.flix.tests.factory;

import com.alura.flix.dto.VideoDto;
import com.alura.flix.dto.VideoSaveDto;
import com.alura.flix.entities.Categoria;
import com.alura.flix.entities.Video;

public class VideoFactory {
	
	public static Video createVideo(Long id, String titulo, String descricao, String url, Categoria categoria) {
		return new Video(id, titulo, descricao, url, categoria);
	}
	
	public static VideoSaveDto createVideoSaveDto(Long id, String titulo, String descricao, String url, Long categoriaId) {
		return new VideoSaveDto(id, titulo, descricao, url, categoriaId);
	}
	
	public static VideoDto createVideoDto(Long id, String titulo, String descricao, String url) {
		return new VideoDto(id, titulo, descricao, url);
	}
	
	public static Video createVideoWithoutCategoria(Long id, String titulo, String descricao, String url) {
		return new Video(id, titulo, descricao, url);
	}
	
}
