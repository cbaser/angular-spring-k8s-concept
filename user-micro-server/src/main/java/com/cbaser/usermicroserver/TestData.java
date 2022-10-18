package com.cbaser.usermicroserver;

import com.cbaser.usermicroserver.model.User;
import com.cbaser.usermicroserver.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequiredArgsConstructor
public class TestData {
    @Autowired
    private final UserService userService;


    @PostConstruct
    public void insertTestData() {
        userService.deleteAll();
        insertTestUsers();
    }

    private void insertTestUsers() {
        log.debug("Inserting test users");
        if (userService.findByEmail("test@user.com").isEmpty()) {
            User testUser1 = new User();
            testUser1.setEmail("test@user.com");
            testUser1.setFirstName("Max");
            testUser1.setLastName("Gentleman");
            testUser1.setBirthday(LocalDate.parse("1990-12-12"));

            userService.saveUser(testUser1);
        }

        if (userService.findByEmail("test2@user.com").isEmpty()) {
            User testUser2 = new User();
            testUser2.setEmail("test2@user.com");
            testUser2.setFirstName("James");
            testUser2.setLastName("Bond");
            testUser2.setBirthday(LocalDate.parse("1992-12-12"));

            userService.saveUser(testUser2);
        }
        if (userService.findByEmail("test3@user.com").isEmpty()) {
            User testUser3 = new User();
            testUser3.setEmail("test3@user.com");
            testUser3.setFirstName("Alice");
            testUser3.setLastName("Wonder-woman");
            testUser3.setBirthday(LocalDate.parse("1952-12-12"));

            userService.saveUser(testUser3);
        }
    }

}

