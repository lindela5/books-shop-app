package com.innowise.darya.controller;

import com.innowise.darya.dto.CustomerDTO;
import com.innowise.darya.service.CustomerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
@Log
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController( CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/getbyid/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public CustomerDTO getCustomerStats(@PathVariable Long id) {
        log.info("Handling find by id request: " + id);
        return customerService.getCustomerStats(id);
    }

}
