package com.budgetmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDTO {
    private Long id;
    private Long categoryId;
    private String categoryName;
    private BigDecimal limitAmount;
    private BigDecimal spentAmount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}

