package com.carlos.valeriano.exception;

public class GroceryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GroceryNotFoundException(Integer id) {
		super("Could not find grocery id: " + id);
	}

	public GroceryNotFoundException(String name) {
		super("Could not find grocery name: " + name);
	}
}
