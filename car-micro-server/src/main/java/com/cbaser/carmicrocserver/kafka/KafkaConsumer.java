package com.cbaser.carmicrocserver.kafka;

import com.cbaser.carmicrocserver.model.Car;
import com.cbaser.carmicrocserver.service.CarService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    private static final String TOPIC = "CarRequest";
    @Autowired
    private final CarService carService;
    private final Gson gson = new Gson();

    public KafkaConsumer(CarService carService) {
        this.carService = carService;
    }

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void consume(String message) {
        Car car = gson.fromJson(message,Car.class);
        logger.info(String.format("#### -> Consumed message -> %s", message));
        carService.saveCar(car);
    }
}
