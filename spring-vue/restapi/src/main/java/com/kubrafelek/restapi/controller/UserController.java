package com.kubrafelek.restapi.controller;

import com.kubrafelek.restapi.repository.UserRepository;

import java.util.List;

import com.kubrafelek.restapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User find(@PathVariable int id) {
        return userRepository.getById(id);
    }
}
