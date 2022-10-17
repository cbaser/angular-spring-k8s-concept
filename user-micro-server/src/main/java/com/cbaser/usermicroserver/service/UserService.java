package com.cbaser.usermicroserver.service;

import com.cbaser.usermicroserver.model.User;
import com.cbaser.usermicroserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public User saveUser(User user){
        Assert.notNull(user,"User must be not null");
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(String id){
        Assert.notNull(id,"Id must be not null");
        return userRepository.findById(id);
    }
    public Optional<User> findByName(String name){
        Assert.notNull(name,"Name must be not null");
        return userRepository.getUserByFirstName(name);
    }
    public Optional<User> findByEmail(String email) {
        Assert.hasLength(email, "Email must not be empty");
        return userRepository.findByEmail(email);
    }
}
