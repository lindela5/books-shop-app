package com.innowise.darya.repositoty;

import com.innowise.darya.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
//   Supplier findById(Long id);
}
