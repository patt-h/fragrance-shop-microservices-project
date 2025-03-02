package com.example.inventoryservice.Service;

import com.example.inventoryservice.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(Long productId, Integer quantity) {
        return inventoryRepository.countByProductIdAndQuantityIsGreaterThanEqual(productId, quantity) > 0;
    }

}
