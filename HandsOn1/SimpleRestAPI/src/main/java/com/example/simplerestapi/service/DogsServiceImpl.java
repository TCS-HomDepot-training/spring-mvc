package com.example.simplerestapi.service;

import com.example.simplerestapi.dto.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogsServiceImpl implements DogsService{

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private List<Dog> dogList = new ArrayList<>();

    @Override
    public List<Dog> getAllDogs() {
        try {
            return this.dogList;
        }catch (Exception e){
            logger.info("Error getting dog list");
            return new ArrayList<>();
        }
    }

    @Override
    public Dog findDogByName(String name){
        try {
            logger.info("Dog found :" + name);
            return searchingDog(new Dog(name, null)).get();
        }catch (Exception e){
            logger.info("Error getting dog");
            return null;
        }
    }

    @Override
    public boolean saveDog(Dog dog) {
        try {
            Optional<Dog> dogF = searchingDog(dog);

            if(!dogF.isPresent()){
                dogList.add(dog);
                logger.info("Inserting dog " + dogF.get().toString());
            }else{
                //dogF.get().setBreed(dog.getBreed());
                logger.info("Already exist " + dog.toString());
                return false;
            }
            return true;
        }catch (Exception e){
            logger.info("Error saving dog");
            return false;
        }
    }

    @Override
    public boolean updateDog(Dog dog) {
        try {
            Optional<Dog> dogF = searchingDog(dog);

            if(dogF.isPresent()){
                dogF.get().setBreed(dog.getBreed());
                logger.info("Updating dog " + dogF.get().toString());
            }else{
                logger.info("Doesnt exist " + dog.toString());
                return false;
            }
            return true;
        }catch (Exception e){
            logger.info("Error saving dog");
            return false;
        }
    }

    @Override
    public boolean deleteDog(String name) {
        try {
            Optional<Dog> dogF = searchingDog(new Dog(name, null));

            if (dogF.isPresent()) {
                dogList.remove(dogF.get());
                logger.info("Removing dog: " + name);
                return true;
            } else {
                logger.info("Doesnt exist : " + name);
                return false;
            }
        }catch (Exception e){
            logger.info("Error deleting dog");
            return false;
        }

    }

    private Optional<Dog> searchingDog(Dog dog){
        return dogList.stream()
                .filter(d -> dog.getName().equals(d.getName()))
                .findFirst();
    }

}
