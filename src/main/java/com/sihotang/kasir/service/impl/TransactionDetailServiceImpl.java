package com.sihotang.kasir.service.impl;

import com.sihotang.kasir.entity.TransactionDetail;
import com.sihotang.kasir.repository.TransactionDetailRepository;
import com.sihotang.kasir.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Override
    @Transactional
    public TransactionDetail createTransactionDetail(TransactionDetail transactionDetail) {
        return transactionDetailRepository.save(transactionDetail);
    }

    @Override
    @Transactional
    public TransactionDetail updateTransactionDetail(Long id, TransactionDetail transactionDetail) {
        TransactionDetail existingTransactionDetail = transactionDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("TransactionDetail not found"));
        existingTransactionDetail.setQuantity(transactionDetail.getQuantity());
        existingTransactionDetail.setPrice(transactionDetail.getPrice());
        // Assuming transaction and stockItem are set elsewhere or handled separately
        return transactionDetailRepository.save(existingTransactionDetail);
    }

    @Override
    @Transactional
    public void deleteTransactionDetail(Long id) {
        transactionDetailRepository.deleteById(id);
    }

    @Override
    public TransactionDetail getTransactionDetailById(Long id) {
        return transactionDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("TransactionDetail not found"));
    }

    @Override
    public List<TransactionDetail> getAllTransactionDetails() {
        return transactionDetailRepository.findAll();
    }
} 