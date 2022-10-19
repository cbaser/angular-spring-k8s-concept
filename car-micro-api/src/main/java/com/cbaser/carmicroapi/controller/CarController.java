package com.cbaser.carmicroapi.controller;

import com.cbaser.carmicroapi.config.ApiConfig;
import com.cbaser.carmicroapi.kafka.KafkaProducer;
import com.cbaser.carmicroapi.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(CarController.class);
    @Inject
    ApiConfig apiConfig;

    @Autowired
    private final KafkaProducer kafkaProducer;

    public CarController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/vehicle/{name}")
    public Car getVehicle(@PathVariable String name) {
        return apiConfig.getForEntity("http://localhost:8082/car/name/" + name, Car.class).getBody();
    }
    @GetMapping("/vehicle")
    public List<Car> getVehicles(){
        ResponseEntity<List<Car>> responseEntity =
                apiConfig.exchange("http://localhost:8082/",
                        HttpMethod.GET, null, createParameterizedTypeReference());
        return responseEntity.getBody();
    }
    ParameterizedTypeReference<List<Car>> createParameterizedTypeReference(){ return new ParameterizedTypeReference<>(){}; }


    @PostMapping("/vehicle")
    public ResponseEntity<String> createVehicle(@RequestBody Car car) {
        logger.info(car.toString());
        logger.info(String.format("Vehicle request recevied: %s", car.getLicensePlate()));
        try{
            this.kafkaProducer.sendCarRequest(car);
            return ResponseEntity.ok().body("Car Created");
        }catch(Exception exception){
            return ResponseEntity.internalServerError().body("Error Creating the car");
        }

    }


}
