package com.learning.userservice.controllers;

import com.learning.userservice.dto.UserDto;
import com.learning.userservice.models.UserDetails;
import com.learning.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping("/getUserServiceHealth")
    public String getUserServiceHealth() {
        return "I am fine, Thanks for checking!!! from User Service";
    }

    @RequestMapping("/getOrderServiceHealth")
    public String getOrderServiceHealth() {
        return userService.getOrderHealth();
    }


    @GetMapping("/findUser/{index}")
    public ResponseEntity<UserDetails> findUser(@PathVariable int index) {
        return new ResponseEntity<>(userService.getUser(index), HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserDetails> saveUser(@RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(userService.saveUser(userDetails), HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{uId}")
    public ResponseEntity<UserDetails> updateUser(@PathVariable int uId, @RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(userService.updateUser(uId, userDetails), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{uId}")
    public ResponseEntity<String> deleteUser(@PathVariable int uId) {
        userService.deleteUser(uId);
        return new ResponseEntity<>("User Deleted with id " + uId, HttpStatus.OK);
    }

    @GetMapping("/orders/{uId}")
    public UserDto getOrders(@PathVariable Integer uId) {
        return userService.getOrderWithUserId(uId);
    }
}