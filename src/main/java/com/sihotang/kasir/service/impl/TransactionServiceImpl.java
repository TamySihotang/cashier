package com.sihotang.kasir.service.impl;

import com.sihotang.kasir.dto.TransactionDTO;
import com.sihotang.kasir.entity.Transaction;
import com.sihotang.kasir.repository.TransactionRepository;
import com.sihotang.kasir.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setDate(transactionDTO.getDate());
        transaction.setTotalAmount(transactionDTO.getTotalAmount());
        // Assuming user and store are set elsewhere or handled separately
        Transaction savedTransaction = transactionRepository.save(transaction);
        return convertToDTO(savedTransaction);
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
        return convertToDTO(transaction);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Double getTotalRevenue() {
        return transactionRepository.findAll().stream().mapToDouble(Transaction::getTotalAmount).sum();
    }

    @Override
    public Long getTotalSales() {
        return transactionRepository.count();
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setDate(transaction.getDate());
        transactionDTO.setTotalAmount(transaction.getTotalAmount());
        if (transaction.getUser() != null) {
            transactionDTO.setUserId(transaction.getUser().getId());
        }
        if (transaction.getStore() != null) {
            transactionDTO.setStoreId(transaction.getStore().getId());
        }
        return transactionDTO;
    }
} 