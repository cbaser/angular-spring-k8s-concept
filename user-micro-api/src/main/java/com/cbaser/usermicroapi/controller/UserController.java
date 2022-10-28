package com.cbaser.usermicroapi.controller;

import com.cbaser.usermicroapi.config.ApiConfig;
import com.cbaser.usermicroapi.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ApiConfig restTemplate;


    @GetMapping(value = "/user/{name}")
    public User getUser(@PathVariable String name) {
        logger.info("Get User By Name");

        return restTemplate.getForEntity("http://localhost:8081/name/" + name, User.class).getBody();
    }
    @GetMapping(value="/user/email/{email}")
    public User getUserEmail(@PathVariable String email){
        logger.info("Get User By Email");

        ResponseEntity<User> responseEntity =
                restTemplate.exchange("http://localhost:8081/email/"+email,
                        HttpMethod.GET, null, new ParameterizedTypeReference<User>(){});
        return responseEntity.getBody();
    }


    @GetMapping(value = "/user")
    public List<User> getUsers(){
        logger.info("Get Users");
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange("http://localhost:8081/",
                        HttpMethod.GET, null, createParameterizedTypeReference());
       return responseEntity.getBody();
    }
    @GetMapping(value="/user")
    public String createUser(@RequestBody User user){
        logger.info("Create User" + user.toString());
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8081/",user,String.class);
        return responseEntity.getBody();
    }


    ParameterizedTypeReference<List<User>> createParameterizedTypeReference(){ return new ParameterizedTypeReference<>(){}; }
}
