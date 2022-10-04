package com.cbaser.carmicroapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarMicroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarMicroApiApplication.class, args);
    }

}
