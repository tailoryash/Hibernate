package com.simform.interviewquestion.Student.Mapper;

import com.simform.interviewquestion.Student.DTO.StudentDto;
import com.simform.interviewquestion.Student.Entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface StudentMapper {

//  StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);

  @Mapping(target = "nameDto", source = "name")
  @Mapping(target = "cityDto", source = "city")
  StudentDto studentDto(Student student);

  @Mapping(target = "name", source = "nameDto")
  @Mapping(target = "city", source = "cityDto")
  Student student(StudentDto studentDto);
}
