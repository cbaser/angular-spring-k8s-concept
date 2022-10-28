package com.cbaser.authservice.service;

import com.cbaser.authservice.entities.LoginRequest;
import com.cbaser.authservice.entities.LoginResponse;
import com.cbaser.authservice.entities.RegisterRequest;
import com.cbaser.authservice.model.User;
import com.cbaser.authservice.util.JwtUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    @Autowired
    private final RestTemplate restTemplate;
    private final JwtUtil jwt;

    @Autowired
    public AuthService(RestTemplate restTemplate,
                       final JwtUtil jwt) {
        this.restTemplate = restTemplate;
        this.jwt = jwt;
    }

    public ResponseEntity<String> register(RegisterRequest registerRequest) {
        //do validation if user already exists
        registerRequest.setPassword(BCrypt.hashpw(registerRequest.getPassword(), BCrypt.gensalt()));
        User user = restTemplate.postForObject("http://user-micro-api/user", registerRequest, User.class);
        if (user != null)
            return ResponseEntity.ok("Registration completed");
        else
            return ResponseEntity.internalServerError().body("Registration is not possible please check later");
    }

    public LoginResponse login(LoginRequest loginRequest) {
        loginRequest.setPassword(BCrypt.hashpw(loginRequest.getPassword(), BCrypt.gensalt()));
        User user = restTemplate.getForObject("http://user-micro-api/user/email/" + loginRequest.getEmail(), User.class);
        Assert.notNull(user, "Failed to find user. Please try again later");
        String accessToken = jwt.generate(user, "ACCESS");
        String refreshToken = jwt.generate(user, "REFRESH");
        return new LoginResponse(user, accessToken, refreshToken);
    }
}
