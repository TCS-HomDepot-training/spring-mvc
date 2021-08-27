package com.thd.training.service;

import com.thd.training.model.GroceryProduct;

import java.util.List;

public interface GroceryProductService {

    GroceryProduct create(GroceryProduct p);
    GroceryProduct update(GroceryProduct p);
    Boolean delete(Integer id);
    GroceryProduct findById(int id);
    List<GroceryProduct> findByName(String name);
}
