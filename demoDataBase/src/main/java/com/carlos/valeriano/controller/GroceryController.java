package com.carlos.valeriano.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.valeriano.exception.GroceryDeleteException;
import com.carlos.valeriano.exception.GroceryNotFoundException;
import com.carlos.valeriano.model.Grocery;
import com.carlos.valeriano.repository.GroceryRepository;

@RestController
public class GroceryController {

	@Autowired
	private GroceryRepository groceryRepository;

	@PostMapping("/")
	public Grocery create(@Valid @RequestBody Grocery grocery) {
		grocery.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
		return groceryRepository.save(grocery);
	}
	
	@PutMapping("/{id}")
	public Grocery update(@Valid @RequestBody Grocery newGrocery, @PathVariable Integer id) {
		boolean exist = groceryRepository.existsById(id);
		if(!exist) {
			throw new GroceryNotFoundException(id);	
		}
		Grocery grocery = groceryRepository.getById(id);
		grocery.setName(newGrocery.getName());
        grocery.setUnitPrice(newGrocery.getUnitPrice());
        grocery.setDiscount(newGrocery.getDiscount());
        grocery.setUnitPrice(newGrocery.getUnitPrice());
        grocery.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
        return groceryRepository.save(grocery);

	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		boolean exist = groceryRepository.existsById(id);
		if(!exist) {
			throw new GroceryDeleteException(id);
		}
		groceryRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Grocery getById(@PathVariable Integer id) {
		Grocery grocery = groceryRepository.findById(id).orElse(null);
		if(grocery == null) {
			throw new GroceryNotFoundException(id);	
		}
		return grocery;
	}
	
	@GetMapping("/getName/{name}")
	public List<Grocery> getByName(@PathVariable String name) {
		List<Grocery> grocerys = groceryRepository.findByName(name);
		if(grocerys.size() == 0) {
			throw new GroceryNotFoundException(name);	
		}
		return grocerys;
	}

	@GetMapping("/all")
	public List<Grocery> getAll() {
		return groceryRepository.findAll();
	}

}
