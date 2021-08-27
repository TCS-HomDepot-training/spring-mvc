package com.carlos.valeriano.exception;

public class GroceryDeleteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GroceryDeleteException(Integer id) {
		super("El recurso solicitado ya no está disponible en el servidor id: " + id);
	}

}
