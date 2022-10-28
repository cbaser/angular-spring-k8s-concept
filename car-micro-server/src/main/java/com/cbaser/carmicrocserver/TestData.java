package com.cbaser.carmicrocserver;

import com.cbaser.carmicrocserver.model.Car;
import com.cbaser.carmicrocserver.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequiredArgsConstructor
public class TestData {
    @Autowired
    private final CarService carService;

    @PostConstruct
    public void insertTestData(){
        carService.deleteAll();
        insertTestCars();
    }

    private void insertTestCars(){
        log.debug("Inserting test cars");
        if(carService.findByName("BMW").isEmpty()){
            Car car = new Car();
            car.setActive(true);
            car.setColor("Black");
            car.setCreationDate(new Date());
            car.setModel("BMW");
            car.setLicensePlate("M-AB 1234");
            car.setVin("ABC234DEF56GH1");
            car.setValidTill(new Date().toString());
            carService.saveCar(car);
        }
        if(carService.findByName("Audi").isEmpty()){
            Car car = new Car();
            car.setActive(true);
            car.setColor("White");
            car.setCreationDate(new Date());
            car.setModel("AUDI");
            car.setLicensePlate("M-AU 4444");
            car.setVin("ABC1234DE1FGH");
            car.setValidTill(new Date().toString());
            carService.saveCar(car);
        }
        if(carService.findByName("VW").isEmpty()){
            Car car = new Car();
            car.setActive(true);
            car.setColor("Gray");
            car.setCreationDate(new Date());
            car.setModel("VW");
            car.setLicensePlate("M-VW 3333");
            car.setVin("ABC1234DE1FGH");
            car.setValidTill(new Date().toString());
            carService.saveCar(car);
        }

    }


}
