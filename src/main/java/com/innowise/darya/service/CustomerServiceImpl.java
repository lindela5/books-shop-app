package com.innowise.darya.service;

import com.innowise.darya.dto.CustomerDTO;
import com.innowise.darya.entity.Customer;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.CustomerRepository;
import com.innowise.darya.transformer.CustomerDTOTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO getCustomerStats(Long customerId) {
        return customerRepository.findById(customerId)
                .map(CustomerDTOTransformer.CUSTOMER_DTO_TRANSFORMER::customerToCustomerDTO)
                .orElseThrow(() -> new ThereIsNoSuchException("customer"));
    }
}

