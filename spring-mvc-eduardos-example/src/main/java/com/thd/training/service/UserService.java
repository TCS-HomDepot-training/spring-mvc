package com.thd.training.service;

import com.thd.training.model.TraineeUser;
import com.thd.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<TraineeUser> getAllUsers() {
        return userRepository.findAll();
    }

    public List<TraineeUser> getByName(String name) {
        return userRepository.findByName(name);
    }

    public List<TraineeUser> getByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public TraineeUser save(TraineeUser traineeUser) {
        return userRepository.save(traineeUser);
    }
}
