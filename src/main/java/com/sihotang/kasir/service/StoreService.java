package com.sihotang.kasir.service;

import com.sihotang.kasir.entity.Store;
import java.util.List;

public interface StoreService {
    Store createStore(Store store);
    Store updateStore(Long id, Store store);
    void deleteStore(Long id);
    Store getStoreById(Long id);
    List<Store> getAllStores();
} 