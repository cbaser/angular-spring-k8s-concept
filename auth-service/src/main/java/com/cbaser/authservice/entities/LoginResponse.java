package com.cbaser.authservice.entities;

import com.cbaser.authservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private User user;
    private String accessToken;
    private String refreshToken;

}
