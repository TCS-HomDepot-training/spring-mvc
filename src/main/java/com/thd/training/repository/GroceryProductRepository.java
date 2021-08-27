package com.thd.training.repository;

import com.thd.training.model.GroceryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface GroceryProductRepository extends JpaRepository<GroceryProduct, Integer> {

    GroceryProduct save(Optional<GroceryProduct> customerToUpdate);
    List<GroceryProduct> findByName(String name);
}
