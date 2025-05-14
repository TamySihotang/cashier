package com.sihotang.kasir.service;

import com.sihotang.kasir.dto.TransactionDTO;
import java.util.List;

public interface TransactionService {
    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    TransactionDTO getTransactionById(Long id);
    List<TransactionDTO> getAllTransactions();
    Double getTotalRevenue();
    Long getTotalSales();
} 