package com.interview.prep.rest.webservies.restfulwebservices.services;

import com.interview.prep.rest.webservies.restfulwebservices.exceptions.UserNotFoundException;
import com.interview.prep.rest.webservies.restfulwebservices.model.Itr;
import com.interview.prep.rest.webservies.restfulwebservices.model.User;
import com.interview.prep.rest.webservies.restfulwebservices.repositories.ItrRepository;
import com.interview.prep.rest.webservies.restfulwebservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItrService {
    @Autowired
    UserService userService;

    @Autowired
    ItrRepository itrRepository;

    public List<Itr> getAllItr(Integer id){
        User user = userService.getUser(id);
        if(null!=user){
            return user.getListOfFiledItr();
        }else{
            throw new UserNotFoundException("Id:"+id);
        }
    }

    public Itr createItrForUser(Integer id,Itr itr){
        User user = userService.getUser(id);
        if(null!=user){
            itr.setUser(user);
        }else{
            return null;
        }
        return itrRepository.save(itr);
    }


}
