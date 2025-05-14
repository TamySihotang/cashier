package com.sihotang.kasir.service;

import com.sihotang.kasir.dto.StockItemDTO;
import java.util.List;

public interface StockItemService {
    StockItemDTO createStockItem(StockItemDTO stockItemDTO);
    StockItemDTO updateStockItem(Long id, StockItemDTO stockItemDTO);
    void deleteStockItem(Long id);
    StockItemDTO getStockItemById(Long id);
    List<StockItemDTO> getAllStockItems();
} 