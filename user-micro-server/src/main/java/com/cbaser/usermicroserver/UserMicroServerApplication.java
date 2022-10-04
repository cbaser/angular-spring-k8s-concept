package com.cbaser.usermicroserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserMicroServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMicroServerApplication.class, args);
    }

}
