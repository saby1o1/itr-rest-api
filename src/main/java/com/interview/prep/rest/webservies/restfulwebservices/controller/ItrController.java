package com.interview.prep.rest.webservies.restfulwebservices.controller;

import com.interview.prep.rest.webservies.restfulwebservices.model.Itr;
import com.interview.prep.rest.webservies.restfulwebservices.services.ItrService;
import com.interview.prep.rest.webservies.restfulwebservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
public class ItrController {
    @Autowired
    ItrService itrService;

    @GetMapping(path = "/users/{id}/itrs")
    public List<Itr> getAllItr(@PathVariable Integer id){
        return itrService.getAllItr(id);
    }

    @PostMapping(path = "/users/{id}/itrs")
    public ResponseEntity<Itr> createItrForUser(@PathVariable Integer id, @RequestBody Itr itr){
        Itr savedItr = itrService.createItrForUser(id,itr);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedItr.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
