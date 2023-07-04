/*
package com.simform.interviewquestion.Student.Mapper;

import com.simform.interviewquestion.Student.DTO.StudentDto;
import com.simform.interviewquestion.Student.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentMapperImpl implements StudentMapper{

  @Autowired StudentDto studentDto;

  @Autowired Student student;
  @Override
  public StudentDto studentDto(Student student) {
    studentDto.setStudentNameDto(student.getName());
    studentDto.setStudentCityDto(student.getCity());
    return studentDto;
  }

  @Override
  public Student student(StudentDto studentDto) {
    student.setName(studentDto.getStudentNameDto());
    student.setCity(studentDto.getStudentCityDto());
    return student;
  }
}
*/
