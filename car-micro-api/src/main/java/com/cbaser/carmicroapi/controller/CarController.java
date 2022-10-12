package com.cbaser.carmicroapi.controller;

import com.cbaser.carmicroapi.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/car/{name}")
    public Car getCar(@PathVariable String name) {
        return restTemplate.getForEntity("http://gateway/car-micro-server/" + name, Car.class).getBody();
    }


    @PostMapping("/car/{name}")
    public void createCar(@PathVariable String name) {
        logger.info(String.format("Car request recevied: %s", name));
        this.template.send("carRequest", new Car(name));
    }


}
