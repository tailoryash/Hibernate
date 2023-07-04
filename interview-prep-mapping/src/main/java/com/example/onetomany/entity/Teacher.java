package com.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int id;
    private String firstName;
    private String lastName;

    //    @JoinColumn(
//            name = "teacher_id" ,
//            referencedColumnName = "teacher_id"
//    )
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();

public void addCourse(Course course) {
    this.courses.add(course);
    course.setTeacher(this);
}
}
