package com.interview.prep.rest.webservies.restfulwebservices.services;

import com.interview.prep.rest.webservies.restfulwebservices.model.User;
import com.interview.prep.rest.webservies.restfulwebservices.model.UserCredDetails;
import com.interview.prep.rest.webservies.restfulwebservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserCredDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        user.orElseThrow( ()->new UsernameNotFoundException("User not found "+username));
        return user.map(UserCredDetails::new).get();
    }
}
