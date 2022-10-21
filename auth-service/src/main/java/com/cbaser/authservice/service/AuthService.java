package com.cbaser.authservice.service;

import com.cbaser.authservice.entities.AuthRequest;
import com.cbaser.authservice.entities.AuthResponse;
import com.cbaser.authservice.model.User;
import com.cbaser.authservice.util.JwtUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    private final RestTemplate restTemplate;
    private final JwtUtil jwt;

    @Autowired
    public AuthService(RestTemplate restTemplate,
                       final JwtUtil jwt) {
        this.restTemplate = restTemplate;
        this.jwt = jwt;
    }

    public AuthResponse register(AuthRequest authRequest) {
        //do validation if user already exists
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));
        User user = restTemplate.postForObject("http://user-micro-api/users/", authRequest, User.class);
        Assert.notNull(user, "Failed to register user. Please try again later");
        return new AuthResponse(null, null);

    }

    public AuthResponse login(AuthRequest authRequest) {
        User user = restTemplate.getForObject("http://user-micro-api/users/" + authRequest.getEmail(), User.class);
        Assert.notNull(user, "Failed to find user. Please try again later");
        String accessToken = jwt.generate(user, "ACCESS");
        String refreshToken = jwt.generate(user, "REFRESH");
        return new AuthResponse(accessToken, refreshToken);
    }
}
