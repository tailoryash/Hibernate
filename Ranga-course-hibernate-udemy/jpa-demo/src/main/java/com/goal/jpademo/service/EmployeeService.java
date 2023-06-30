package com.goal.jpademo.service;

import com.goal.jpademo.entity.inheritance.Employee;
import com.goal.jpademo.entity.inheritance.FullTimeEmployee;
import com.goal.jpademo.entity.inheritance.PartTimeEmployee;
import com.goal.jpademo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.saveEmployee(employee);
    }

    public List<PartTimeEmployee> findAllPartTimeEmployees() {
        return employeeRepository.retrieveAllPartTimeEmployees();
    }

    public List<FullTimeEmployee> findAllFullTimeEmployees() {
        return employeeRepository.retrieveAllFullTimeEmployees();
    }
}
