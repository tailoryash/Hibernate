package com.simform.jpamapping.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ename")
    private String empName;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "emp_workstation",
            joinColumns = {
                    @JoinColumn(name = "employee_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "workstation_id", referencedColumnName = "id")
            }
    )
    private WorkStation workStation;
}
