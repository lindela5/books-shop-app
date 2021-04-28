package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishing_house")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublishingHouse {

    @Id
    private Long publishingHouseId;
    private String namePublisher;
    private String address;



}
