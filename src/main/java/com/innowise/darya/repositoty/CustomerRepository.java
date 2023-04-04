package com.innowise.darya.repositoty;

import com.innowise.darya.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Customer findByCustomerId(Long customerId);
}
