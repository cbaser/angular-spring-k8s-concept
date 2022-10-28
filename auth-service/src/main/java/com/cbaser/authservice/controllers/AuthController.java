package com.cbaser.authservice.controllers;

import com.cbaser.authservice.entities.LoginRequest;
import com.cbaser.authservice.entities.LoginResponse;
import com.cbaser.authservice.entities.RegisterRequest;
import com.cbaser.authservice.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/auth/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        logger.info("Register is called with: "+ registerRequest.toString());
        return authService.register(registerRequest);
    }
    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        logger.info("Login is called with:" + loginRequest.toString());
        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
