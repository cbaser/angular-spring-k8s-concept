package com.cbaser.carmicrocserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarMicroServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarMicroServerApplication.class, args);
    }

}
