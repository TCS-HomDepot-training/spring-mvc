package com.grocery.controller;

import com.grocery.entity.Grocery;
import com.grocery.repository.GroceryRepository;
import com.grocery.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
@CrossOrigin(origins = "*")
public class GroceryController {

    @Autowired
    @Qualifier("groceryServiceImpl")
    private GroceryService groceryService;

    @GetMapping("/list")
    public List<Grocery> getAllDogs() {
        return groceryService.listAll();
    }

    @GetMapping("/{id}")
    public Grocery getGroceryById(@PathVariable Integer id) {
        return groceryService.findById(id);
    }

    @GetMapping
    public Grocery getGroceryByName(@RequestParam(value="name") String name) {
        return groceryService.findByName(name);
    }

    @PostMapping
    public Grocery saveGrocery(@RequestBody Grocery grocery) {
        return groceryService.save(grocery);
    }

    @PutMapping
    public Grocery updateGrocery(@RequestBody Grocery grocery) {
        return groceryService.update(grocery);
    }

    @DeleteMapping("/{id}")
    public void deleteGrocery(@PathVariable Integer id) {
        groceryService.delete(id);
    }

}
