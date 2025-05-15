package com.budgetmanager.controller;

import com.budgetmanager.dto.CategoryDTO;
import com.budgetmanager.service.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    public CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/addCategory")
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
        System.out.println(categoryDTO.getName()+"::::::::::::::::::::::::::::::");
        return categoryService.saveCategory(categoryDTO);
    }
    @GetMapping("/allcategorys")
    public List<CategoryDTO> getAllCategorys() {
        return categoryService.getAllCategories();
    }
    @GetMapping("/category/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getcategoryById(id);
    }
    @PutMapping("category/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id  ,@RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(id, categoryDTO);
    }
    @DeleteMapping("/suppCategory/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
