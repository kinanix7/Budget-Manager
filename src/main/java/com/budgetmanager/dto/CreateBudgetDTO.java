package com.budgetmanager.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
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
public class CreateBudgetDTO {

    @NotNull(message = "L\"ID de la catégorie ne peut pas être nul")
    private Long categoryId;

    @NotNull(message = "Le montant limite ne peut pas être nul")
    @DecimalMin(value = "0.01", message = "Le montant limite doit être positif")
    private BigDecimal limitAmount;

    // Optionnel: pour définir la période du budget
    private LocalDate startDate;
    private LocalDate endDate;
}

