package com.innowise.darya.controller;

import com.innowise.darya.dto.SectionDTO;
import com.innowise.darya.dto.SupplierDTO;
import com.innowise.darya.entity.Supplier;
import com.innowise.darya.service.SupplierService;
import com.innowise.darya.transformer.SupplierDTOTransformer;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/supplier")
@Log
public class SupplierController {
    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @GetMapping("/getbyid/{id}")
    public SupplierDTO getSupplierStats(@PathVariable long id) {
        log.info("Handling find by id request: " + id);
        return supplierService.getSupplierStats(id);
    }

}
