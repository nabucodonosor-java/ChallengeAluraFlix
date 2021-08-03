package com.alura.flix.tests.factory;

import com.alura.flix.dto.CategoriaDto;
import com.alura.flix.entities.Categoria;

public class CategoriaFactory {
	
	public static Categoria createCategoria(Long id, String titulo, String cor) {
		return new Categoria(id, titulo, cor);
	}
	
	public static CategoriaDto createCategoriaDto(Long id, String titulo, String cor) {
		return new CategoriaDto(id, titulo, cor);
	}
	
	public static CategoriaDto createCategoriaDtoAutoIncrementId(String titulo, String cor) {
		return new CategoriaDto(titulo, cor);
	}

}
