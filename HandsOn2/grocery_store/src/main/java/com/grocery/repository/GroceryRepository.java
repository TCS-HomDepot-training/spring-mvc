package com.grocery.repository;

import com.grocery.entity.Grocery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("groceryRepository")
public interface GroceryRepository extends CrudRepository<Grocery, Integer> {
}
