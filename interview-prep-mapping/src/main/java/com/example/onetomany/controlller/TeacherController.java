package com.example.onetomany.controlller;

import com.example.onetomany.entity.Course;
import com.example.onetomany.entity.Teacher;
import com.example.onetomany.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @PostMapping
    public void create(@RequestBody Teacher teacher) {
        teacherService.create(teacher);
    }
    @GetMapping
    public List<Teacher> getAll() {
       return teacherService.getAll();
    }
    @PostMapping ("/{id}")
    public void addCourseById(@PathVariable("id") int id, @RequestBody Course course) {
        teacherService.addCourseById(id,course);
    }

}
