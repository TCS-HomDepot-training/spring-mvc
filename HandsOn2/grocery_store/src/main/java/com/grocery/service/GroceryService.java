package com.grocery.service;

import com.grocery.entity.Grocery;

import java.util.List;

public interface GroceryService {
    List<Grocery> listAll();
    Grocery findById(Integer id);
    Grocery findByName(String name);
    Grocery save(Grocery grocery);
    Grocery update(Grocery grocery);
    void delete(Integer id);
}
