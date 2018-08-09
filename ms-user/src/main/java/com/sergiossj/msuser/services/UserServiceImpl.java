package com.sergiossj.msuser.services;

import com.sergiossj.msuser.entities.User;
import com.sergiossj.msuser.repositories.UserRepository;
import com.sergiossj.msuser.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class UserServiceImpl implements UserService {

    @Value("${spring.kafka.topic.userCreated}")
    private  String USER_CREATED_TOPIC;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Sender sender;

    @Override
    public User registerUser(User input) {
        System.out.println("registerUser"+input);
        User createdUser = userRepository.save(input);
        System.out.println("Created user"+createdUser+USER_CREATED_TOPIC);
        sender.send(USER_CREATED_TOPIC, createdUser);
        return createdUser;
    }

    @Override
    public Iterable<User> findAll() {
        Iterable<User> userIterable=userRepository.findAll();
        return userIterable;
    }

}