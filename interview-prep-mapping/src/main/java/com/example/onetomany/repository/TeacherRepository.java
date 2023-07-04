package com.example.onetomany.repository;

import com.example.onetomany.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
