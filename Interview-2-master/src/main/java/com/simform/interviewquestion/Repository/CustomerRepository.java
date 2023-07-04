package com.simform.interviewquestion.Repository;

import com.simform.interviewquestion.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
}
