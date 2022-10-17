package com.cbaser.usermicroserver.controller;

import com.cbaser.usermicroserver.model.User;
import com.cbaser.usermicroserver.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public List<User> getUsers() {
        logger.info("UserService - GetUsers");
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        logger.info(String.format("UserService - GetUser By Id:"+  id));
        return userService.findById(id);
    }
    @GetMapping("/{name}")
    public Optional<User> getUserByName(@PathVariable String name){
        logger.info(String.format("UserService - GetUser By Name:"+  name));
        return userService.findByName(name);
    }
    @GetMapping("/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email){
        logger.info(String.format("UserService - GetUser By Name:"+  email));
        return userService.findByEmail(email);
    }
    @PostMapping(
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> addUser(@RequestBody String userString){
        User user = new User();
        user.setFirstName(userString);
        User persistedUser = userService.saveUser(user);

        return ResponseEntity
                .created(URI
                        .create(String.format("/Users/%s", persistedUser.getBirthday())))
                .body(persistedUser);
    }
    
}
