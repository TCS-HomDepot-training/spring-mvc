package com.thd.training.controller;

import com.thd.training.DTO.*;
import com.thd.training.DTO.ControllerExceptions.GroceryProduct.*;
import org.springframework.http.ResponseEntity;

public interface GroceryProductController {

    public ResponseEntity<CreateGroceryProductResponse> create(CreateGroceryProductRequest gp) throws CreateGroceryProductException;
    public ResponseEntity<UpdateGroceryProductResponse> update(UpdateGroceryProductRequest gp) throws UpdateGroceryProductException;
    public ResponseEntity<DeletteGroceryProductResponse> delete (DeleteGroceryProductRequest gp) throws DeleteGroceryProductException;

    public FindByIdGroceryProductResponse findById(Integer id) throws FindByIdGroceryProductException;
    public FindByNameGroceryProductResponse findByName(String name) throws FindByNameGroceryProductException;
}
