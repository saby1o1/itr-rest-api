package com.interview.prep.rest.webservies.restfulwebservices.controller;

import com.interview.prep.rest.webservies.restfulwebservices.exceptions.UserNotFoundException;
import com.interview.prep.rest.webservies.restfulwebservices.model.User;
import com.interview.prep.rest.webservies.restfulwebservices.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EFillingController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable Integer id){
        User user =userService.getUser(id);
        if(user==null)
            throw new UserNotFoundException("id :"+id);

        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
       User savedUser = userService.saveUser(user);
       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedUser.getId())
               .toUri();
       return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Integer id){
       userService. deleteUser(id);
    }

}
