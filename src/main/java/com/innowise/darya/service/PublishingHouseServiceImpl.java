package com.innowise.darya.service;

import com.innowise.darya.dto.PublishingHouseDTO;
import com.innowise.darya.entity.PublishingHouse;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.PublishingHouseRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.innowise.darya.transformer.PublishingHouseDTOTransformer.*;

@Service
@Transactional
public class PublishingHouseServiceImpl implements PublishingHouseService {

    private PublishingHouseRepository publishingHouseRepository;

    public PublishingHouseServiceImpl(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }


    public PublishingHouseDTO getPublisherStats(Long publishingHouseId) {
        return publishingHouseRepository.findById(publishingHouseId)
                .map(PUBLISHING_HOUSE_DTO_TRANSFORMER::publishingHouseToPublishingHouseDTO)
                .orElseThrow(() -> new ThereIsNoSuchException("publisher"));
    }

}
