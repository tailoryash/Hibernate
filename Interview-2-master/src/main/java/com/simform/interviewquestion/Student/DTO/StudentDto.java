package com.simform.interviewquestion.Student.DTO;


import lombok.*;
import lombok.experimental.Accessors;

public class StudentDto {
  String nameDto;
  String cityDto;

  public StudentDto(String nameDto, String cityDto) {
    this.nameDto = nameDto;
    this.cityDto = cityDto;
  }

  public String getNameDto() {
    return nameDto;
  }

  public String getCityDto() {
    return cityDto;
  }

  public void setNameDto(String nameDto) {
    this.nameDto = nameDto;
  }

  public void setCityDto(String cityDto) {
    this.cityDto = cityDto;
  }
}
