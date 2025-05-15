package com.budgetmanager.service;

import com.budgetmanager.dto.TransactionDTO;
import com.budgetmanager.mapper.TransactionMapper;
import com.budgetmanager.model.Transaction;
import com.budgetmanager.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    private TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::transactionToDTO)
                .toList();
    }
    public TransactionDTO getTransactionById(Long id) {
        return transactionRepository.findById(id).map(transactionMapper::transactionToDTO)
                .orElseThrow(()-> new RuntimeException("Transaction not found"));


    }

}