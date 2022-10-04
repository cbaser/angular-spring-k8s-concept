package com.cbaser.carmicrocserver.repository;

import com.cbaser.carmicrocserver.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends MongoRepository<Car,String> {
    @Query("{name: ?0}")
    Optional<Car> getCarByName(String id);

}
