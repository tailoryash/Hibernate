package com.simform.interviewquestion.Student.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "student")
public class Student {
  @Column(name = "city")
  String city;
  @Column(name = "salary")
  Double salary;
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "password")
  private String password;


  public Student() {
  }

  public Student(String city, Double salary, Long id, String name, String password) {
    this.city = city;
    this.salary = salary;
    this.id = id;
    this.name = name;
    this.password = password;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
