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
public class PartTimeEmployee extends Employee {
    private BigDecimal hourlyWage;

    public PartTimeEmployee(String name, Address address, BigDecimal hourlyWage) {
        super(name, address);
        this.hourlyWage = hourlyWage;

    }

}
