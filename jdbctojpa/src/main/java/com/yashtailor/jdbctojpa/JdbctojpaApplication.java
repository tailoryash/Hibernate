package com.yashtailor.jdbctojpa;

import com.yashtailor.jdbctojpa.entity.*;
import com.yashtailor.jdbctojpa.jdbc.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import java.util.*;

@SpringBootApplication
@Slf4j
public class JdbctojpaApplication implements CommandLineRunner {
    @Autowired
    PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(JdbctojpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("All Users -> {}", personJdbcDao.findAll());
        log.info("User id 10001 -> {}", personJdbcDao.findById(10001));
        log.info("User id 10001 deleted -> {}", personJdbcDao.deleteById(10001));
        log.info("Inserting 10004 -> {}", personJdbcDao.insert(new Person(10004, "Yash", "Ahmedabad", new Date())));
        log.info("Updating 10003 -> {}", personJdbcDao.update(new Person(10003, "mohit", "Ahmedabad", new Date())));

    }
}
