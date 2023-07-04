package com.simform.interviewquestion.Service;

import com.simform.interviewquestion.CutomerDto.CustomerDto;
import com.simform.interviewquestion.CutomerDto.CustomerDtoMapper;
import com.simform.interviewquestion.Entity.Customer;
import com.simform.interviewquestion.Exception.NotFoundRequestException;
import com.simform.interviewquestion.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerService {
  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  CustomerDtoMapper customerDtoMapper;


  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  public List<CustomerDto> getAll(){
    return customerRepository.findAll()
            .stream()
            .map(customerDtoMapper).collect(Collectors.toList());
  }

  public void deleteCustomer(Long id) {
    if (customerRepository.existsById(id)){
      customerRepository.deleteById(id);
    }
    else{
      throw new NotFoundRequestException("For delete Customer , Id Not Found");
    }

  }

}
