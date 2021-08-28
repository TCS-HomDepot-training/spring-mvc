package com.store.grocery.dto;

import java.util.List;

public class GenericResponse<T> {
	
	private List<T> object;
	private String statusCode;
	private String message;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<T> getObject() {
		return object;
	}

	public void setObject(List<T> object) {
		this.object = object;
	}
	
}
