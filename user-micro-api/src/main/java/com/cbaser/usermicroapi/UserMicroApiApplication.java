package com.cbaser.usermicroapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserMicroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMicroApiApplication.class, args);
    }

}
