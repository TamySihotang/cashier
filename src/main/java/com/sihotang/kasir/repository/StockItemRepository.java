package com.sihotang.kasir.repository;

import com.sihotang.kasir.entity.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Long> {
    // Add custom query methods if needed
} 