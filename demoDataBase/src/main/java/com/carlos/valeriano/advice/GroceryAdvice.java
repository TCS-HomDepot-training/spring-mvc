package com.carlos.valeriano.advice;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.carlos.valeriano.exception.GroceryDeleteException;
import com.carlos.valeriano.exception.GroceryNotFoundException;

@ControllerAdvice
public class GroceryAdvice {

	@ResponseBody
	@ExceptionHandler(GroceryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(GroceryNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(GroceryDeleteException.class)
	@ResponseStatus(HttpStatus.GONE)
	String employeeNotFoundHandler(GroceryDeleteException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String employeeNotFoundHandler(ConstraintViolationException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String employeeNotFoundHandler(MethodArgumentNotValidException ex) {
		return ex.getMessage();
	}
	
}
