package com.budgetmanager.repository;

import com.budgetmanager.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Optional<Budget> findByCategoryId(Long categoryId);

}