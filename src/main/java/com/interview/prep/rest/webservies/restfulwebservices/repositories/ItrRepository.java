package com.interview.prep.rest.webservies.restfulwebservices.repositories;

import com.interview.prep.rest.webservies.restfulwebservices.model.Itr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItrRepository extends JpaRepository<Itr,Integer> {
}
