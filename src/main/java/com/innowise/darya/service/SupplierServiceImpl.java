package com.innowise.darya.service;

import com.innowise.darya.dto.SectionDTO;
import com.innowise.darya.dto.SupplierDTO;
import com.innowise.darya.entity.Section;
import com.innowise.darya.entity.Supplier;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SupplierRepository;
import com.innowise.darya.transformer.SectionDTOTransformer;
import com.innowise.darya.transformer.SupplierDTOTransformer;
import com.innowise.darya.transformer.SupplyDTOTransformer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    public SupplierDTO getSupplierStats(Long id) {
        return supplierRepository.findById(id)
                .map(SupplierDTOTransformer.SUPPLIER_DTO_TRANSFORMER::supplierToSupplierDTO)
                .orElseThrow(() -> new ThereIsNoSuchException("supplier"));
    }

}

