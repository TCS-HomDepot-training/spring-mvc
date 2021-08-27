package com.carlos.valeriano.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.valeriano.model.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {

	List<Grocery> findAll();

    List<Grocery> findByName(String name);

    Grocery findById(int id);
    
}
