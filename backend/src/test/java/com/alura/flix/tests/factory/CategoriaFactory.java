package com.alura.flix.tests.factory;

import com.alura.flix.entities.Categoria;

public class CategoriaFactory {
	
	public static Categoria createCategoria(Long id, String titulo, String cor) {
		return new Categoria(id, titulo, cor);
	}

}
