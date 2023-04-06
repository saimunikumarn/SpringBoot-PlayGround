package com.hibernatedemo.controllers;

import com.hibernatedemo.dao.UserDetails;
import com.hibernatedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody UserDetails u) {
        return userService.saveUser(u);
    }

    @GetMapping("/user/{id}")
    public UserDetails getUser(@PathVariable Integer id) {
        return userService.findUser(id);
    }


}