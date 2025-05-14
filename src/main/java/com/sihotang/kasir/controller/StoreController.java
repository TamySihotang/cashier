package com.sihotang.kasir.controller;

import com.sihotang.kasir.entity.Store;
import com.sihotang.kasir.service.StoreService;
import com.sihotang.kasir.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<ApiResponse<Store>> createStore(@RequestBody Store store) {
        try {
            Store createdStore = storeService.createStore(store);
            return ResponseEntity.ok(ApiResponse.success("Store created successfully", createdStore));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Store>> updateStore(@PathVariable Long id, @RequestBody Store store) {
        try {
            Store updatedStore = storeService.updateStore(id, store);
            return ResponseEntity.ok(ApiResponse.success("Store updated successfully", updatedStore));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStore(@PathVariable Long id) {
        try {
            storeService.deleteStore(id);
            return ResponseEntity.ok(ApiResponse.success("Store deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Store>> getStoreById(@PathVariable Long id) {
        try {
            Store store = storeService.getStoreById(id);
            return ResponseEntity.ok(ApiResponse.success("Store retrieved successfully", store));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Store>>> getAllStores() {
        try {
            List<Store> stores = storeService.getAllStores();
            return ResponseEntity.ok(ApiResponse.success("Stores retrieved successfully", stores));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }
} 