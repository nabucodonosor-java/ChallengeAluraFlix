package com.alura.flix.services.exceptions;

public class CategoriaUniqueException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CategoriaUniqueException(String msg) {
		super(msg);
	}

}
