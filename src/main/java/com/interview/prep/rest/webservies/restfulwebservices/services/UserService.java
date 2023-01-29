package com.interview.prep.rest.webservies.restfulwebservices.services;

import com.interview.prep.rest.webservies.restfulwebservices.model.User;
import com.interview.prep.rest.webservies.restfulwebservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
