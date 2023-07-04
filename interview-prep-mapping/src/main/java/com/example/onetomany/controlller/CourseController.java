package com.example.onetomany.controlller;

import com.example.onetomany.entity.Teacher;
import com.example.onetomany.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping("/{id}")
    public void updateTeacherByCourse(@PathVariable("id") int courseId ,@RequestBody Teacher teacher) {
        courseService.updateTeacherByCourse(courseId,teacher);
    }
    @PostMapping("/teacher/{id}")
    public void addTeacherByCourse(@PathVariable("id") int courseId ,@RequestBody Teacher teacher) {
        courseService.addNewTeacherByCourse(courseId,teacher);
    }
}
