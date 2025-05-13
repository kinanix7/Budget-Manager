package com.budgetmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetDTO {
    private Long id;
    private Long categoryId;
    private String categoryName; // For display purposes
    private BigDecimal limitAmount;
    private BigDecimal spentAmount; // To be calculated in the service layer
    private LocalDate startDate;
    private LocalDate endDate;
}

