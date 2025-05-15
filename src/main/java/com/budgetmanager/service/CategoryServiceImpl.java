package com.budgetmanager.service;

import com.budgetmanager.dto.CategoryDTO;
import com.budgetmanager.mapper.CategoryMapper;
import com.budgetmanager.mapper.TransactionMapper;
import com.budgetmanager.repository.CategoryRepository;
import com.budgetmanager.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl {


    private final CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;
    private final TransactionMapper transactionMapper;
    @Autowired
    private TransactionRepository transactionRepository;

    public  CategoryServiceImpl(CategoryRepository categoryRepository,
                                TransactionMapper transactionMapper) {
        this.categoryRepository = categoryRepository;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
      return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(categoryDTO)));
    }
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    public CategoryDTO getcategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("cat not found"));
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id).map(cat -> {
           cat.setName(categoryDTO.getName());
            return categoryMapper.toDto(categoryRepository.save(cat));
        }).orElseThrow(() -> new RuntimeException("category not found"));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }









}
