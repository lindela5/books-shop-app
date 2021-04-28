package com.innowise.darya.service;

import com.innowise.darya.dto.CustomerDTO;


public interface CustomerService {

    CustomerDTO getCustomerStats(Long customerId);
}
