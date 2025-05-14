package com.sihotang.kasir.controller;

import com.sihotang.kasir.dto.StockItemDTO;
import com.sihotang.kasir.service.StockItemService;
import com.sihotang.kasir.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-items")
public class StockItemController {

    @Autowired
    private StockItemService stockItemService;

    @PostMapping
    public ResponseEntity<ApiResponse<StockItemDTO>> createStockItem(@RequestBody StockItemDTO stockItemDTO) {
        try {
            StockItemDTO createdStockItem = stockItemService.createStockItem(stockItemDTO);
            return ResponseEntity.ok(ApiResponse.success("Stock item created successfully", createdStockItem));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StockItemDTO>> updateStockItem(@PathVariable Long id, @RequestBody StockItemDTO stockItemDTO) {
        try {
            StockItemDTO updatedStockItem = stockItemService.updateStockItem(id, stockItemDTO);
            return ResponseEntity.ok(ApiResponse.success("Stock item updated successfully", updatedStockItem));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStockItem(@PathVariable Long id) {
        try {
            stockItemService.deleteStockItem(id);
            return ResponseEntity.ok(ApiResponse.success("Stock item deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StockItemDTO>> getStockItemById(@PathVariable Long id) {
        try {
            StockItemDTO stockItem = stockItemService.getStockItemById(id);
            return ResponseEntity.ok(ApiResponse.success("Stock item retrieved successfully", stockItem));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StockItemDTO>>> getAllStockItems() {
        try {
            List<StockItemDTO> stockItems = stockItemService.getAllStockItems();
            return ResponseEntity.ok(ApiResponse.success("Stock items retrieved successfully", stockItems));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }
} 