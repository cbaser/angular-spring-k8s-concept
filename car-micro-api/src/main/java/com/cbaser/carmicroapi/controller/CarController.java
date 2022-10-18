package com.cbaser.carmicroapi.controller;

import com.cbaser.carmicroapi.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/vehicle/{name}")
    public Car getCar(@PathVariable String name) {
        return restTemplate.getForEntity("http://gateway/car-micro-server/" + name, Car.class).getBody();
    }
    @GetMapping("/vehicle")
    public List<Car> getCars(){
        ResponseEntity<List<Car>> responseEntity =
                restTemplate.exchange("http://localhost:8082/",
                        HttpMethod.GET, null, createParameterizedTypeReference());
        return responseEntity.getBody();
    }
    ParameterizedTypeReference<List<Car>> createParameterizedTypeReference(){ return new ParameterizedTypeReference<>(){}; }


    @PostMapping("/vehicle/{name}")
    public void createCar(@PathVariable String name) {
        logger.info(String.format("Car request recevied: %s", name));
        this.template.send("carRequest", new Car(name));
    }


}
