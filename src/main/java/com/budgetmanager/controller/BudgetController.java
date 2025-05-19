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
    public ResponseEntity<BudgetDTO> createBudget(@RequestBody BudgetDTO budgetDTO) {
        BudgetDTO createdBudget = budgetService.createBudget(budgetDTO);
        return ResponseEntity.ok(createdBudget);
    }

    @GetMapping
    public ResponseEntity<List<BudgetDTO>> getAllBudgets() {
        return ResponseEntity.ok(budgetService.getAllBudgets());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }
}
