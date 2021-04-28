package com.innowise.darya.service;

import com.innowise.darya.dto.SectionDTO;
import com.innowise.darya.entity.Section;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SectionRepository;
import com.innowise.darya.transformer.SectionDTOTransformer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService{

    private SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public SectionDTO getSectionStats(Long sectionId) {
        Optional<Section> section = Optional.ofNullable(sectionRepository.findById(sectionId));
        if (!section.isPresent()) {
            throw new ThereIsNoSuchException("section");
        }
        SectionDTO sectionDTO = SectionDTOTransformer.SECTION_DTO_TRANSFORMER.sectionToSectionDTO(section.get());
        return sectionDTO;
    }





    @Override
    public List<SectionDTO> getAllSection() {
        List<SectionDTO> sectionDTOList = new ArrayList<>();
        List<Section> sectionList = sectionRepository.findAll();
        for (Section section : sectionList) {
            sectionDTOList.add(SectionDTOTransformer.SECTION_DTO_TRANSFORMER.sectionToSectionDTO(section));
        }
        return sectionDTOList;
    }


}
