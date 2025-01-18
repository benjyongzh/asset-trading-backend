package com.tradingapp.user_service.controllers;

import com.tradingapp.user_service.models.User;
import com.tradingapp.user_service.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public User add(@RequestBody User user){
        LOGGER.info("add user: {}", user);
        return userRepository.addUser(user);
    }

    @GetMapping
    public List<User> findAll(){
        LOGGER.info("client findAll");
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        LOGGER.info("user findById: {}", id);
        return userRepository.findById(id);
    }


    @PostMapping("/validateuserbycode/{userCode}")
    public boolean validateUserByCode(@PathVariable String userCode){
        LOGGER.info("user validateByCode: {}", userCode);
        return userRepository.validateUserByCode(userCode);
    }

}
