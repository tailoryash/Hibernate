package com.goal.jpademo.repository;

import com.goal.jpademo.entity.inheritance.Employee;
import com.goal.jpademo.entity.inheritance.FullTimeEmployee;
import com.goal.jpademo.entity.inheritance.PartTimeEmployee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Employee saveEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    public List<Employee> findAll(){
        List<Employee> employees = entityManager.createQuery("Select e From Employee e", Employee.class).getResultList();
        return employees;
    }

    public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
        return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
        return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }
}
