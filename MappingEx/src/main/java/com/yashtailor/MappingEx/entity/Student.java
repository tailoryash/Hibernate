package com.yashtailor.MappingEx.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;
}
