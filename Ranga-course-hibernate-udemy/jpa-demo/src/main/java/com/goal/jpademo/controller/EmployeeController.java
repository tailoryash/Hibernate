package com.goal.jpademo.controller;

import com.goal.jpademo.entity.inheritance.Employee;
import com.goal.jpademo.entity.inheritance.FullTimeEmployee;
import com.goal.jpademo.entity.inheritance.PartTimeEmployee;
import com.goal.jpademo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @PostMapping("/part-time")
    public Employee savePartTimeEmployee(@RequestBody PartTimeEmployee employee){
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/full-time")
    public Employee savePartTimeEmployee(@RequestBody FullTimeEmployee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/part-time")
    public List<PartTimeEmployee> getPartTimeEmployees(){
        return employeeService.findAllPartTimeEmployees();
    }

    @GetMapping("/full-time")
    public List<FullTimeEmployee> getFullTimeEmployees(){
        return employeeService.findAllFullTimeEmployees();
    }

}
