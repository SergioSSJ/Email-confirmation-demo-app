package com.sergiossj.msuser.services;

import com.sergiossj.msuser.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


public interface UserService {
    User registerUser(User user);
    Iterable<User> findAll();
}
