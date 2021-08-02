package com.alura.flix.tests.factory;

import com.alura.flix.entities.Categoria;
import com.alura.flix.entities.Video;

public class VideoFactory {
	
	public static Video createVideo(Long id, String titulo, String descricao, String url, Categoria categoria) {
		return new Video(id, titulo, descricao, url, categoria);
	}
	
}
