package com.cbaser.authservice.controllers;

import com.cbaser.authservice.entities.AuthRequest;
import com.cbaser.authservice.entities.AuthResponse;
import com.cbaser.authservice.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest authRequest) {
        logger.info("Register is called");
        return ResponseEntity.ok(authService.register(authRequest));
    }
    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest){
        logger.info("Login is called");
        return ResponseEntity.ok(authService.login(authRequest));
    }
}
