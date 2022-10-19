package com.cbaser.carmicrocserver.controller;

import com.cbaser.carmicrocserver.model.Car;
import com.cbaser.carmicrocserver.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public List<Car> getCars() {
        return carService.findAll();
    }
    @GetMapping("/id/{id}")
    public Optional<Car> getCarById(@PathVariable String id){
        return carService.findById(id);
    }
    @GetMapping("/name/{name}")
    public Optional<Car> getCarByName(@PathVariable String name){
        return carService.findByName(name);
    }
}
