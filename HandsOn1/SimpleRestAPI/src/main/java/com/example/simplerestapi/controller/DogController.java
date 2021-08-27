package com.example.simplerestapi.controller;

import com.example.simplerestapi.dto.Dog;
import com.example.simplerestapi.service.DogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/dogs")
public class DogController {

    @Autowired
    DogsService dogsService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String getHelloWorld() {
        return "WELCOME TO THE WORLD OF SPRING";
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogsService.getAllDogs();
    }

    @GetMapping("/dogs/{name}")
    public Dog getDogByName(@PathVariable String name) {
        return dogsService.findDogByName(name);
    }

    @PostMapping("/dogs")
    boolean newEmployee(@RequestBody Dog dog) {
        return dogsService.saveDog(dog);
    }

    @DeleteMapping("/dogs/{name}")
    boolean deleteEmployee(@PathVariable String name) {
        return dogsService.deleteDog(name);
    }

    @PutMapping("/dogs/{name}")
    boolean replaceDogBreed(@RequestBody Dog dog, @PathVariable String name) {
        dog.setName(name);
        return dogsService.updateDog(dog);
    }


}
