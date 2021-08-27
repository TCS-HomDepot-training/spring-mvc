package com.example.simplerestapi.service;

import com.example.simplerestapi.dto.Dog;

import java.util.List;

public interface DogsService {

    List<Dog> getAllDogs();
    Dog findDogByName(String name);
    boolean saveDog(Dog dog);
    boolean updateDog(Dog dog);
    boolean deleteDog(String name);

}
