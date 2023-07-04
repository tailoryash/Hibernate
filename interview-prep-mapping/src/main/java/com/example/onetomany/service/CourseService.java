package com.example.onetomany.service;

import com.example.onetomany.entity.Course;
import com.example.onetomany.entity.Teacher;
import com.example.onetomany.repository.CourseRepository;
import com.example.onetomany.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public void updateTeacherByCourse(int courseId , Teacher teacher ) {
        Optional<Course> byId = courseRepository.findById(courseId);
        if (byId.isPresent()) {
            System.out.println(teacher);
            Course course = byId.get();
            Teacher existingTeacher = course.getTeacher();
            existingTeacher.setFirstName(teacher.getFirstName());
            existingTeacher.setLastName(teacher.getLastName());
            courseRepository.save(course);
        }
    }

    public void addNewTeacherByCourse(int id , Teacher teacher) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            if(teacher.getId() == 0){
                teacher.addCourse(course);
                courseRepository.save(course);
            }else {
                Optional<Teacher> optionalTeacher = teacherRepository.findById(teacher.getId());
                if(optionalTeacher.isPresent()){
                    optionalTeacher.get().addCourse(course);
                    courseRepository.save(course);
                }
                else{
                    throw new RuntimeException("teacher not found");
                }
            }
        }
    }

}
