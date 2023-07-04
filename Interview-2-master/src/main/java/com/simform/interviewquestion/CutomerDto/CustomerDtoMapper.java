package com.simform.interviewquestion.CutomerDto;

import com.simform.interviewquestion.Entity.Customer;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

@Service
public class CustomerDtoMapper implements Function<Customer , CustomerDto> {
  @Override
  public CustomerDto apply(Customer customer) {
    return new CustomerDto(
            customer.getFirstName(),
            customer.getLastName(),
            convertToAge(customer.getDob())
    );
  }


  public int convertToAge(LocalDate dob){
    LocalDate currentDate = LocalDate.now();
    LocalDate birthDate = dob;
    Period period = Period.between(birthDate , currentDate) ;

    return  period.getYears();
  }
}
