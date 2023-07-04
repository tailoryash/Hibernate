package com.simform.interviewquestion.Student.Controller;


import com.simform.interviewquestion.Student.DTO.StudentDto;
import com.simform.interviewquestion.Student.Entity.Student;
import com.simform.interviewquestion.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired StudentService studentService;


  @PostMapping("/create")
  public ResponseEntity<Student> saveStudent(@RequestBody Student student){
    Student studented = studentService.createStudent(student);
    return new ResponseEntity<>(studented , HttpStatus.CREATED);
  }


  @GetMapping("/{id}")
  public ResponseEntity<StudentDto> getStudent(@PathVariable("id") long id){
    StudentDto studentDto = studentService.getStudent(id);
    return new ResponseEntity<>(studentDto, HttpStatus.FOUND);
  }

}
