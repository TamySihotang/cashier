package com.sihotang.kasir.service.impl;

import com.sihotang.kasir.entity.Store;
import com.sihotang.kasir.repository.StoreRepository;
import com.sihotang.kasir.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    @Transactional
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    @Transactional
    public Store updateStore(Long id, Store store) {
        Store existingStore = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
        existingStore.setName(store.getName());
        existingStore.setAddress(store.getAddress());
        return storeRepository.save(existingStore);
    }

    @Override
    @Transactional
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
} 