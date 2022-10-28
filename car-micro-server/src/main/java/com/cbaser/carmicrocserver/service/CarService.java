package com.cbaser.carmicrocserver.service;

import com.cbaser.carmicrocserver.model.Car;
import com.cbaser.carmicrocserver.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car saveCar(Car car){
        Assert.notNull(car,"Car must be not null");
        return carRepository.save(car);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Optional<Car> findById(String id){
        Assert.notNull(id,"Id must be not null");
        return carRepository.findById(id);
    }
    public Optional<Car> findByName(String name){
        Assert.notNull(name,"Name must be not null");
        return carRepository.getCarByName(name);
    }
    public void deleteAll(){
        carRepository.deleteAll();
    }




}
