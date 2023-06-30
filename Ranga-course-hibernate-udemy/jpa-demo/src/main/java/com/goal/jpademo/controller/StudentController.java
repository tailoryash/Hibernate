package com.goal.jpademo.controller;


import com.goal.jpademo.dto.StudentCourseDto;
import com.goal.jpademo.entity.relation.Student;
import com.goal.jpademo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;
    @GetMapping("/students")
    public List<Student> studentList(){
        return studentService.findStudents();
    }

    @GetMapping("/{id}")
    public Student studentList(@PathVariable int id){
        return studentService.findStudent(id);
    }

    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @PutMapping("/students/enroll")
    public String enroll(@RequestBody StudentCourseDto studentCourseDto) {
        return studentService.enroll(studentCourseDto);
    }

    @GetMapping("/students/criteria")
    public List<Student> studentsWithStartingLetterA(){
        return studentService.studentsWithStartingLetterA();
    }
}
