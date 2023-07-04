package com.simform.interviewquestion.Controller;

import com.simform.interviewquestion.CutomerDto.CustomerDto;
import com.simform.interviewquestion.Entity.Customer;
import com.simform.interviewquestion.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
  @Autowired
  CustomerService customerService;

  @GetMapping
  public ResponseEntity<List<CustomerDto>> getAllCustomerByDto(){
    List<CustomerDto> customerList = customerService.getAll();
    return new ResponseEntity<>(customerList, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Customer> saveStudent(@RequestBody Customer customer){
    customer = customerService.createCustomer(customer);
    return new ResponseEntity<>(customer , HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return ResponseEntity.ok("deleted customer of id " + id);
  }

}
