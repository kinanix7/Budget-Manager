package com.budgetmanager.dto;

import com.budgetmanager.model.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
public class CreateTransactionDTO {

    @NotNull(message = "Le montant ne peut pas être nul")
    @DecimalMin(value = "0.01", message = "Le montant doit être positif")
    private BigDecimal amount;

    @NotNull(message = "Le type de transaction ne peut pas être nul")
    private TransactionType type;

    @NotNull(message = "L\'ID de la catégorie ne peut pas être nul")
    private Long categoryId;

    @NotNull(message = "La date ne peut pas être nulle")
    @PastOrPresent(message = "La date ne peut pas être dans le futur")
    private LocalDate date;

    private String description;
}

