package com.example.onetomany.service;

import com.example.onetomany.entity.Course;
import com.example.onetomany.entity.Teacher;
import com.example.onetomany.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public void create(Teacher teacher) {
        teacher.getCourses().forEach(course -> course.setTeacher(teacher));
        teacherRepository.save(teacher);
    }
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }
    public void addCourseById(int id,Course course) {
        Optional<Teacher> byId = teacherRepository.findById(id);
        if(byId.isPresent()) {
            Teacher teacher = byId.get();
            teacher.addCourse(course);
            teacherRepository.save(teacher);

        }
        else {
            throw new RuntimeException("Teacher not found");
        }
    }


}
