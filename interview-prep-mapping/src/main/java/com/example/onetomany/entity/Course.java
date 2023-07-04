package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacher_id"
    )
    @JsonIgnore
    private Teacher teacher;
}
