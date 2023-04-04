package com.innowise.darya.service;

import com.innowise.darya.dto.SupplierDTO;
import com.innowise.darya.entity.Supplier;


public interface SupplierService {

    SupplierDTO getSupplierStats(Long id);

}