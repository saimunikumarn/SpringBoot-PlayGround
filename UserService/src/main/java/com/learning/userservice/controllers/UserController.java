package com.learning.userservice.controllers;

import com.learning.userservice.models.User;
import com.learning.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    ArrayList<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User(1, "user 1", "Hyderabad", "9999999999"));
        users.add(new User(2, "user 2", "Bangalore", "8888888888"));
    }

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello!!!";
    }

    @GetMapping("/findUser")
//    @RequestMapping(value = "/findUser/{index}", method = RequestMethod.GET)
    public ResponseEntity<User> findUser(@RequestParam int index) {
        return new ResponseEntity<>(userService.getUser(index, users), HttpStatus.OK);
    }

    @PostMapping("/saveUser")
//    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User userDetails) {
        users.add(userDetails);
        return new ResponseEntity<>(userService.getUser(userDetails.getUId(), users), HttpStatus.CREATED);
    }

    //to save multiple users at once
    @RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
    public List<User> saveUser(@RequestBody List<User> userDetails) {
        users.addAll(userDetails);
        return new ArrayList<>(users);
    }

    @PutMapping("/updateUser/{uId}")
//    @RequestMapping(value = "/updateUser/{uId}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable int uId, @RequestBody User userDetails) {
        return new ResponseEntity<>(userService.updateUser(uId, userDetails, users), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{uId}")
    public ResponseEntity<String> deleteUser(@PathVariable int uId) {
        User existingUser = userService.getUser(uId, users);
        users.remove(existingUser);
        return new ResponseEntity<>("User Deleted with id " + uId, HttpStatus.OK);
    }
}