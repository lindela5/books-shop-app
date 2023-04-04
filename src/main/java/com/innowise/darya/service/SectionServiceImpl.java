package com.innowise.darya.service;

import com.innowise.darya.dto.SectionDTO;
import com.innowise.darya.entity.Section;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SectionRepository;
import com.innowise.darya.transformer.SectionDTOTransformer;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

    private SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public SectionDTO getSectionStats(Long sectionId) {
        return sectionRepository.findById(sectionId)
                .map(SectionDTOTransformer.SECTION_DTO_TRANSFORMER::sectionToSectionDTO)
                .orElseThrow(() -> new ThereIsNoSuchException("section"));
    }


    @Override
    @Transactional(readOnly = true)
    public List<SectionDTO> getAllSection() {
        return sectionRepository.findAllSections()
                .map(SectionDTOTransformer.SECTION_DTO_TRANSFORMER::sectionToSectionDTO)
                .collect(Collectors.toList());
    }


}
