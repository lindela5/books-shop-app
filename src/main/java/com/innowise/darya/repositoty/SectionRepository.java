package com.innowise.darya.repositoty;


import com.innowise.darya.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;


public interface SectionRepository extends JpaRepository<Section, Long> {
//    Section findById(Long id);
//can create
    default Stream<Section> findAllSections() {
        return this.findAll().stream();
    };
}
