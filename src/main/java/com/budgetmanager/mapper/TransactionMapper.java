package com.budgetmanager.mapper;

import com.budgetmanager.dto.TransactionDTO;
import com.budgetmanager.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionDTO transactionToDTO(Transaction transaction);


    @Mapping(target = "category", ignore = true)
    @Mapping(target = "type", source = "type", defaultValue = "DEPENSE")
    @Mapping(target = "date", source = "date", defaultExpression = "java(java.time.LocalDate.now())")
    Transaction transactionToEntity(TransactionDTO transactionDTO);

}