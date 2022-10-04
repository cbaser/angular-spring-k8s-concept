package com.cbaser.usermicroapi.controller;

import com.cbaser.usermicroapi.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/user/{name}")
    public User getUser(@PathVariable String name) {
        return restTemplate.getForEntity("http://gateway/user-micro-server/" + name, User.class).getBody();
    }
    @PostMapping("/user/{name}")
    public void createUser(@PathVariable String name) {
        logger.info(String.format("User request recevied: %s", name));
        this.template.send("newUser", new User(name));
    }
}
