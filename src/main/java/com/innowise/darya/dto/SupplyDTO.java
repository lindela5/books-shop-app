package com.innowise.darya.dto;

import com.innowise.darya.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplyDTO {

    private Long supplyId;
    private List<BookDTO> bookSupply;
    private Supplier supplier;
    private LocalDate supplyDate;
    private BigDecimal supplierPrice;

}