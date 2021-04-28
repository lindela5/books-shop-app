package com.innowise.darya.dto;

import com.innowise.darya.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long orderId;
    private Set<BookDTO> bookOrder;// = new HashSet<>();
    private Customer customer;
    private LocalDate orderDate;
    private BigDecimal amount;
}
