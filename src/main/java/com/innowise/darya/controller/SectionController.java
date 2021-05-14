package com.innowise.darya.controller;

import com.innowise.darya.dto.SectionDTO;
import com.innowise.darya.service.SectionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/section")
@Log
public class SectionController {
    private SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }


    @GetMapping("/findAll")
    public List<SectionDTO> getAllSection() {
        return sectionService.getAllSection();
    }

    @GetMapping("/getbyid/{id}")
    public SectionDTO getCustomerStats(@PathVariable Long id) {
        log.info("Handling find by id request: " + id);
        return sectionService.getSectionStats(id);
    }

}

