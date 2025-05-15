package com.budgetmanager.dto;

import com.budgetmanager.model.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TransactionDTO {
    private Long id;
    private BigDecimal amount;
    private TransactionType type;
    private Long categoryId;
    private String categoryName; // For display purposes
    private LocalDate date;
    private String description;
}

