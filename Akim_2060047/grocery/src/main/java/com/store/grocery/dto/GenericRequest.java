package com.store.grocery.dto;

import java.util.List;

public class GenericRequest<T> {

	private List<T> object;

	public List<T> getObject() {
		return object;
	}

	public void setObject(List<T> object) {
		this.object = object;
	}
	
}
