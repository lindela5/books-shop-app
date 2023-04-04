package com.innowise.darya.controller;

import com.innowise.darya.dto.PublishingHouseDTO;
import com.innowise.darya.dto.SupplierDTO;
import com.innowise.darya.entity.PublishingHouse;
import com.innowise.darya.service.PublishingHouseService;
import com.innowise.darya.transformer.PublishingHouseDTOTransformer;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/publishingHouse")
@Log
public class PublishingHouseController {

    private PublishingHouseService publishingHouseService;

    @Autowired
    public PublishingHouseController(PublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }


    @GetMapping("/getbyid/{id}")
    public PublishingHouseDTO getPublishingHouseStats(@PathVariable Long id) {
        log.info("Handling find by id request: " + id);
        return publishingHouseService.getPublisherStats(id);
    }


}
