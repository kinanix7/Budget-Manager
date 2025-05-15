package com.budgetmanager.mapper;

import com.budgetmanager.dto.BudgetDTO;
import com.budgetmanager.model.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BudgetMapper {
    BudgetMapper INSTANCE = Mappers.getMapper(BudgetMapper.class);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(target = "spentAmount", ignore = true)
    BudgetDTO budgetToBudgetDTO(Budget budget);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Budget budgetDTOToBudget(BudgetDTO budgetDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateBudgetFromDTO(BudgetDTO budgetDTO, @MappingTarget Budget budget);

    List<BudgetDTO> budgetsToBudgetDTOs(List<Budget> budgets);
}