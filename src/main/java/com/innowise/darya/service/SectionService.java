package com.innowise.darya.service;

import com.innowise.darya.dto.SectionDTO;

import java.util.List;


public interface SectionService {

    SectionDTO getSectionStats(Long sectionId);
    List<SectionDTO> getAllSection();


}
