package com.sihotang.kasir.service;

import com.sihotang.kasir.entity.TransactionDetail;
import java.util.List;

public interface TransactionDetailService {
    TransactionDetail createTransactionDetail(TransactionDetail transactionDetail);
    TransactionDetail updateTransactionDetail(Long id, TransactionDetail transactionDetail);
    void deleteTransactionDetail(Long id);
    TransactionDetail getTransactionDetailById(Long id);
    List<TransactionDetail> getAllTransactionDetails();
}
 