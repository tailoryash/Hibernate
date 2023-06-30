package com.goal.jpademo.entity.inheritance;

import com.goal.jpademo.entity.embed.Address;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullTimeEmployee extends Employee{
    private BigDecimal salary;

    public FullTimeEmployee(String name, Address address, BigDecimal salary) {
        super(name, address);
        this.salary = salary;

    }

}
