package com.grocery.service.impl;

import com.grocery.entity.Grocery;
import com.grocery.repository.GroceryRepository;
import com.grocery.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("groceryServiceImpl")
@Transactional
public class GroceryServiceImpl implements GroceryService {

    @Autowired
    @Qualifier("groceryRepository")
    private GroceryRepository groceryRepository;


    @Override
    public List<Grocery> listAll() {
        return (List<Grocery>) groceryRepository.findAll();
    }

    @Override
    public Grocery findById(Integer id) {
        return groceryRepository.findById(id).get();
    }

    @Override
    public Grocery findByName(String name) {
        return null;
    }

    @Override
    public Grocery save(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    @Override
    public Grocery update(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    @Override
    public void delete(Integer id) {
        groceryRepository.deleteById(id);
    }
}
