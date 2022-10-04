package com.cbaser.carmicrocserver.controller;

import com.cbaser.carmicrocserver.model.Car;
import com.cbaser.carmicrocserver.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public List<Car> getCars() {
        return carService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable String id){
        return carService.findById(id);
    }
    @GetMapping("/{name}")
    public Optional<Car> getCarByName(@PathVariable String name){
        return carService.findByName(name);
    }
    @PostMapping(
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Car> addCar(@RequestBody String carString){
        Car car = new Car(carString);
        Car persistedCar = carService.saveCar(car);

        return ResponseEntity
                .created(URI
                        .create(String.format("/cars/%s", car.getCreationDate())))
                .body(persistedCar);
    }
}
