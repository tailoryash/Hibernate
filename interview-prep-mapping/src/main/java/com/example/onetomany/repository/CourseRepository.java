package com.example.onetomany.repository;

import com.example.onetomany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
