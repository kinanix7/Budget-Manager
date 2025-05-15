package com.budgetmanager.service;

import com.budgetmanager.mapper.BudgetMapper;
import com.budgetmanager.repository.BudgetRepository;
import com.budgetmanager.repository.CategoryRepository;
import com.budgetmanager.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;




    @Transactional
    public void deleteBudget(Long id){

        budgetRepository.deleteById(id);
    }
}