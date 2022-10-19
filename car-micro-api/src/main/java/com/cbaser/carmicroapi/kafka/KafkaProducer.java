package com.cbaser.carmicroapi.kafka;

import com.cbaser.carmicroapi.model.Car;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC = "CarRequest";

    @Autowired
    private KafkaTemplate<String, String> template;

    private final Gson gson = new Gson();

    public void sendCarRequest(Car car) {
        logger.info(String.format("#### -> Producing message -> %s", car.getLicensePlate()));
        this.template.send(TOPIC, gson.toJson(car));
    }

}
