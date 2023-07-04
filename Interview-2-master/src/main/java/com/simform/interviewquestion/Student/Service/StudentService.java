package com.simform.interviewquestion.Student.Service;

import com.simform.interviewquestion.Student.DTO.StudentDto;
import com.simform.interviewquestion.Student.Entity.Student;
import com.simform.interviewquestion.Student.Mapper.StudentMapper;
import com.simform.interviewquestion.Student.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  @Autowired
  StudentRepository studentRepository;

  @Autowired
  StudentMapper studentMapper;


  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }


  public StudentDto getStudent(long studentId) {
    Student student = studentRepository.findById(studentId).get();
//    if (student != null) {
//
//    }


//    StudentDto map = modelMapper.map(student, StudentDto.class);
    return null;
  }

  ;
}
