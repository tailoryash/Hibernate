package com.yashtailor.jdbctojpa.jdbc;

import com.yashtailor.jdbctojpa.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.util.*;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person
    public List<Person> findAll(){
       return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }

    public int insert(Person person){
        return jdbcTemplate.update(
            "insert into person(id, name, location, birth_date)" + "values(?, ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
    }

    public int update(Person person){
        return jdbcTemplate.update(
                "update person " + " set name = ? , location = ?, birth_date = ? " + "where id=?",
                person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()
                );
    }
}
