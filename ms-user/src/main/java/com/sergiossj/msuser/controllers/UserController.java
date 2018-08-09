package com.sergiossj.msuser.controllers;


import com.sergiossj.msuser.entities.User;
import com.sergiossj.msuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantLock;

@RestController("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/member")
    public ResponseEntity<Iterable<User>> getAll(){
        Iterable<User> all=userService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("/member")
    public ResponseEntity<User> register(@RequestBody User user){
        System.out.println("POST /member"+user);
        User result=userService.registerUser(user);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
