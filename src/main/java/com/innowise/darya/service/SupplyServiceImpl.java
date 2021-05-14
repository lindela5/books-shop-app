package com.innowise.darya.service;

import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SupplyRepository;
import com.innowise.darya.transformer.SupplyDTOTransformer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {

    private SupplyRepository supplyRepository;

    public SupplyServiceImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }


    @Override
    public SupplyDTO getSupplyById(Long id) {
        return supplyRepository.findById(id)
                .map(SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER::supplyToSupplyDTO)
                .orElseThrow(() -> new ThereIsNoSuchException("supply"));
    }

    @Override
    public SupplyDTO saveSupply(SupplyDTO supplyDto) {
        Supply savedSupply = supplyRepository.saveAndFlush(SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER.supplyDTOToSupply(supplyDto));
        return SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER.supplyToSupplyDTO(savedSupply);
    }

    @Override
    public void deleteSupply(Long supplyId) {
        supplyRepository.deleteById(supplyId);
    }

}
