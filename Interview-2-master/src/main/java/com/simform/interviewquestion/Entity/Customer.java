package com.simform.interviewquestion.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@Table(name = "customer")
public class Customer {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  @Column(name = "first_name")
  String firstName;

  @Column(name = "last_name")
  String lastName;

  @Column(name = "address")
  String address;

  @Column(name = "dob")
  LocalDate dob;

}
