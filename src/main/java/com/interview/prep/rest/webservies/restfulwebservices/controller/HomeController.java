package com.interview.prep.rest.webservies.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(path = "/")
    public String all(){
        return "<H1>Hello All !!</H1>";
    }

    @GetMapping(path = "/users")
    public String getUser(){
        return "<H1>Welcome User</H1>";
    }

    @GetMapping(path = "/admin")
    public String getAdmin(){
        return "<H1>Welcome Admin</H1>";
    }
}
