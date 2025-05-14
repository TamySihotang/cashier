package com.sihotang.kasir.repository;

import com.sihotang.kasir.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {
    // Add custom query methods if needed
} 