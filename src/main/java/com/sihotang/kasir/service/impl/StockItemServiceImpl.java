package com.sihotang.kasir.service.impl;

import com.sihotang.kasir.dto.StockItemDTO;
import com.sihotang.kasir.entity.StockItem;
import com.sihotang.kasir.repository.StockItemRepository;
import com.sihotang.kasir.service.StockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockItemServiceImpl implements StockItemService {

    @Autowired
    private StockItemRepository stockItemRepository;

    @Override
    @Transactional
    public StockItemDTO createStockItem(StockItemDTO stockItemDTO) {
        StockItem stockItem = new StockItem();
        stockItem.setName(stockItemDTO.getName());
        stockItem.setPrice(stockItemDTO.getPrice());
        stockItem.setQuantity(stockItemDTO.getQuantity());
        // Assuming store is set elsewhere or handled separately
        StockItem savedStockItem = stockItemRepository.save(stockItem);
        return convertToDTO(savedStockItem);
    }

    @Override
    @Transactional
    public StockItemDTO updateStockItem(Long id, StockItemDTO stockItemDTO) {
        StockItem stockItem = stockItemRepository.findById(id).orElseThrow(() -> new RuntimeException("StockItem not found"));
        stockItem.setName(stockItemDTO.getName());
        stockItem.setPrice(stockItemDTO.getPrice());
        stockItem.setQuantity(stockItemDTO.getQuantity());
        // Assuming store is set elsewhere or handled separately
        StockItem updatedStockItem = stockItemRepository.save(stockItem);
        return convertToDTO(updatedStockItem);
    }

    @Override
    @Transactional
    public void deleteStockItem(Long id) {
        stockItemRepository.deleteById(id);
    }

    @Override
    public StockItemDTO getStockItemById(Long id) {
        StockItem stockItem = stockItemRepository.findById(id).orElseThrow(() -> new RuntimeException("StockItem not found"));
        return convertToDTO(stockItem);
    }

    @Override
    public List<StockItemDTO> getAllStockItems() {
        return stockItemRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private StockItemDTO convertToDTO(StockItem stockItem) {
        StockItemDTO stockItemDTO = new StockItemDTO();
        stockItemDTO.setId(stockItem.getId());
        stockItemDTO.setName(stockItem.getName());
        stockItemDTO.setPrice(stockItem.getPrice());
        stockItemDTO.setQuantity(stockItem.getQuantity());
        if (stockItem.getStore() != null) {
            stockItemDTO.setStoreId(stockItem.getStore().getId());
        }
        return stockItemDTO;
    }
} 