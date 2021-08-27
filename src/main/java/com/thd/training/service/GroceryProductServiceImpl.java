package com.thd.training.service;

import com.thd.training.model.GroceryProduct;
import com.thd.training.repository.GroceryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GroceryProductServiceImpl implements GroceryProductService{

    @Autowired
    GroceryProductRepository gpr;

    @Override
    public GroceryProduct create(GroceryProduct p) {
        return gpr.save(p);
    }

    @Override
    public GroceryProduct update(GroceryProduct p) {
        return gpr.save(p);
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            gpr.deleteById(id);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public GroceryProduct findById(int id) {
        Optional<GroceryProduct> op = gpr.findById(id);
        if(op.isPresent())
            return op.get();
        return null;

    }

    @Override
    public List<GroceryProduct> findByName(String name) {
        return gpr.findByName(name);

    }
}
