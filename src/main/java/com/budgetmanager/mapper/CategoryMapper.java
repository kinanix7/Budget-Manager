package com.budgetmanager.mapper;

import com.budgetmanager.dto.CategoryDTO;
import com.budgetmanager.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

   // CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO categoryDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "transactions", ignore = true)
    @Mapping(target = "budget", ignore = true)
    Category updateCategoryFromDTO(CategoryDTO categoryDTO, @MappingTarget Category category);
}