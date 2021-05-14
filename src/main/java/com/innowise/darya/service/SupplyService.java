package com.innowise.darya.service;

import com.innowise.darya.dto.SupplyDTO;


public interface SupplyService {

    SupplyDTO getSupplyById(Long id);

    SupplyDTO saveSupply(SupplyDTO supplyDto);

    void deleteSupply(Long supplyId);

}
