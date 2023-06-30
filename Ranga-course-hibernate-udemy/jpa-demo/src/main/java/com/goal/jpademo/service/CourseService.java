package com.goal.jpademo.service;

import com.goal.jpademo.entity.relation.Course;
import com.goal.jpademo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course findCourse(int id) {
        return courseRepository.findById(id);
    }

    public List<Course> findCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.updateCourse(course);
    }

    public Course updateCourse(Course course) {
        return courseRepository.updateCourse(course);
    }
}
