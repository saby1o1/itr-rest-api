package com.interview.prep.rest.webservies.restfulwebservices.repositories;

import com.interview.prep.rest.webservies.restfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
