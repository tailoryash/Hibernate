package com.simform.jpamapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workstation")
public class WorkStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "workstation_number")
    private Integer Number;
    private String floor;
    @OneToOne(mappedBy = "workStation")
    private Employee employee;
}
