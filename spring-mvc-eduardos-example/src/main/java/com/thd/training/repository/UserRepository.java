package com.thd.training.repository;

import com.thd.training.model.TraineeUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<TraineeUser, Integer> {

    List<TraineeUser> findAll();

    List<TraineeUser> findByName(String name);

    List<TraineeUser> findByUsername(String username);
}
