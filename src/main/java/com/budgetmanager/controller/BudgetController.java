package com.budgetmanager.controller;

import com.budgetmanager.dto.BudgetDTO;
import com.budgetmanager.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping
    public BudgetDTO createBudget(@RequestBody BudgetDTO budgetDTO) {
        BudgetDTO createdBudget = budgetService.createBudget(budgetDTO);
        return (createdBudget);
    }

    @GetMapping
    public List<BudgetDTO> getAllBudgets() {
        return (budgetService.getAllBudgets());
    }
    @PutMapping("/{id}")
    public BudgetDTO updateBudget(@PathVariable Long id, @RequestBody BudgetDTO budgetDTO) {
        return (budgetService.updateBudget(id, budgetDTO));
    }

    @DeleteMapping("/{id}")
    public Void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return null;
    }
}
