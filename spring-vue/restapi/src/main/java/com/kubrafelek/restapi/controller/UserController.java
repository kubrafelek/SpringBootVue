package com.kubrafelek.restapi.controller;

import com.kubrafelek.restapi.repository.UserRepository;

import java.util.List;

import com.kubrafelek.restapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/users")
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

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User old = userRepository.findById(id).orElse(null);
        old.setName(user.getName());
        old.setEmail(user.getEmail());
        old.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    Integer deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return id;
    }
}
