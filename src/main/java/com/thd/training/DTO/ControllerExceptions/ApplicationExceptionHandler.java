package com.thd.training.DTO.ControllerExceptions;

import com.thd.training.DTO.ControllerExceptions.GroceryProduct.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(CreateGroceryProductException.class)
    public ResponseEntity handleExceptionOnCreateGroceryProduct(CreateGroceryProductException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UpdateGroceryProductException.class)
    public ResponseEntity handleExceptionOnUpdateGroceryProduct(UpdateGroceryProductException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(DeleteGroceryProductException.class)
    public ResponseEntity handleExceptionOnDeleteGroceryProduct(DeleteGroceryProductException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(FindByIdGroceryProductException.class)
    public ResponseEntity handleExceptionOnDeleteGroceryProduct(FindByIdGroceryProductException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(FindByNameGroceryProductException.class)
    public ResponseEntity handleExceptionOnDeleteGroceryProduct(FindByNameGroceryProductException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
