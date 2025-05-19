package com.budgetmanager.service;

import com.budgetmanager.dto.BudgetDTO;
import com.budgetmanager.mapper.BudgetMapper;
import com.budgetmanager.model.Budget;
import com.budgetmanager.repository.BudgetRepository;
import com.budgetmanager.repository.CategoryRepository;
import com.budgetmanager.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

@Transactional
public BudgetDTO createBudget(BudgetDTO dto) {
    Budget budget = budgetMapper.budgetDTOToBudget(dto);
    budget.setCategory(categoryRepository.findById(dto.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Category not found")));
    return budgetMapper.budgetToBudgetDTO(budgetRepository.save(budget));
}



    public List<BudgetDTO> getAllBudgets() {
        return budgetRepository.findAll().stream()
                .map(budgetMapper::budgetToBudgetDTO)
                .collect(Collectors.toList());
    }





    public void deleteBudget(Long id){

        budgetRepository.deleteById(id);
    }
}