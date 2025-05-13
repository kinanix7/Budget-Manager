package com.budgetmanager.repository;

import com.budgetmanager.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {


}