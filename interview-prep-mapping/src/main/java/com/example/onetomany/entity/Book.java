package com.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @ManyToOne
    private Author author;
}
