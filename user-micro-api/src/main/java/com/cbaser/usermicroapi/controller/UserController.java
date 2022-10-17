package com.cbaser.usermicroapi.controller;

import com.cbaser.usermicroapi.config.ApiConfig;
import com.cbaser.usermicroapi.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ApiConfig restTemplate;


    @RequestMapping(value = "/user/{name}",method = RequestMethod.GET)
    public User getUser(@PathVariable String name) {
        logger.info("GetUser");

        return restTemplate.getForEntity("http://localhost:8081/" + name, User.class).getBody();
    }
    @RequestMapping(value = "/user/",method = RequestMethod.GET)
    public List<User> getUsers(){
        logger.info("Get Users");
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange("http://localhost:8081/",
                        HttpMethod.GET, null, createParameterizedTypeReference());
       return responseEntity.getBody();
    }
    ParameterizedTypeReference<List<User>> createParameterizedTypeReference(){ return new ParameterizedTypeReference<>(){}; }
}
