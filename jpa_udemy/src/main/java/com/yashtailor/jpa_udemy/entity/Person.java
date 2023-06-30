package com.yashtailor.jpa_udemy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name="find_all_persons", query =  "select p from Person p")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Person(String name, String location, Date birthdate) {
        this.name = name;
        this.location = location;
        this.birthdate = birthdate;
    }

    private String name;
    private String location;
    private Date birthdate;

}
