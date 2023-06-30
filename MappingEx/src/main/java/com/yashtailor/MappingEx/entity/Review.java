package com.yashtailor.MappingEx.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rating;
    private String description;

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    @ManyToOne
    private Course course;
}
