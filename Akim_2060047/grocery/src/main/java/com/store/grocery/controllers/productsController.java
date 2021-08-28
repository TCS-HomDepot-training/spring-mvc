package com.store.grocery.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.grocery.dto.RequestProduct;
import com.store.grocery.dto.ResponseProduct;
import com.store.grocery.services.ProductService;
import com.store.grocery.utils.HttpCodes;
import com.store.grocery.utils.ValidateData;

@RestController
@RequestMapping("/products")
public class productsController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<ResponseProduct> getAll(){
		ResponseProduct response = productService.readAll();
		ValidateData.dataNotFound(response);
		return new ResponseEntity<>(response,HttpCodes.codesMap.get(response.getStatusCode()));
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseProduct> getById(@PathVariable Integer id) {
		ResponseProduct response = new ResponseProduct();
		if(ValidateData.request(id, response)) {
			response = productService.getById(id);
			ValidateData.dataNotFound(response);
		}
		return new ResponseEntity<>(response, HttpCodes.codesMap.get(response.getStatusCode()));
	}
	
	@GetMapping("/product")
	public ResponseEntity<ResponseProduct> getByName(@RequestParam String name) {
		ResponseProduct response = productService.getByName(name);
		ValidateData.dataNotFound(response);
		return new ResponseEntity<>(response, HttpCodes.codesMap.get(response.getStatusCode()));

	}
	
	@PostMapping
	public ResponseEntity<ResponseProduct> create(@RequestBody RequestProduct request) {
		ResponseProduct response = new ResponseProduct();
		if(ValidateData.request(request, response)) {
			response = productService.create(request.getObject());
		}
		return new ResponseEntity<>(response, HttpCodes.codesMap.get(response.getStatusCode()));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseProduct> update(@RequestBody RequestProduct request) {
		ResponseProduct response = new ResponseProduct();
		if(ValidateData.request(request, response)) {
			response = productService.update(request.getObject());
		}
		return new ResponseEntity<>(response, HttpCodes.codesMap.get(response.getStatusCode()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseProduct> delete(@PathVariable int id) {
		ResponseProduct response = new ResponseProduct();
		if(ValidateData.request(id, response)) {
			response = productService.delete(id);
		}
		return new ResponseEntity<>(response, HttpCodes.codesMap.get(response.getStatusCode()));
	}
}
