package com.yashtailor.jpa_udemy;

import com.yashtailor.jpa_udemy.entity.*;
import com.yashtailor.jpa_udemy.jpa.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import java.util.*;

@SpringBootApplication
@Slf4j
public class JpaUdemyApplication implements CommandLineRunner {

    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaUdemyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("User id 10001->{}", personJpaRepository.findById(10001));
        log.info("Inserting  -> {}", personJpaRepository.insert(new Person("Yash", "Ahmedabad", new Date())));
        log.info("Updating 10003 -> {}", personJpaRepository.update(new Person("mohit", "Ahmedabad", new Date())));
        personJpaRepository.deleteById(10002);
        log.info("All Users -> {}", personJpaRepository.findAll());

    }
}
