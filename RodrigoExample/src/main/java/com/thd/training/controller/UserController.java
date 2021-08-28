package com.thd.training.controller;

import com.thd.training.model.TraineeUser;
import com.thd.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    List<TraineeUser> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get")
    List<TraineeUser> getUsersByName(@RequestParam(name = "name") String name) {
        return userService.getByName(name);
    }

    @GetMapping("/get/{username}")
    List<TraineeUser> getUsersByUserName(@PathVariable String username) {
        return userService.getByUserName(username);
    }

    @PostMapping("/save")
    TraineeUser getSave(@RequestBody TraineeUser traineeUser) {
        return userService.save(traineeUser);
    }
}
