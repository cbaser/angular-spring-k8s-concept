package com.cbaser.usermicroserver.repository;

import com.cbaser.usermicroserver.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    @Query("{firstName: ?0}")
    Optional<User> getUserByFirstName(String name);
    @Query("{email:  ?0}")
    Optional<User> findByEmail(String email);
}
