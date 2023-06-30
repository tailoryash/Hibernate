package com.goal.jpademo.controller;

import com.goal.jpademo.entity.relation.Course;
import com.goal.jpademo.repository.CourseRepository;
import com.goal.jpademo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    private final CourseRepository courseRepository;
    @GetMapping
    public List<Course> studentList(){
        return courseService.findCourses();
    }

    @GetMapping("/{id}")
    public Course studentList(@PathVariable int id){
        return courseService.findCourse(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }

    @PostMapping
    public Course saveEducator(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping
    public Course updateEducator(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

}
