package com.example.inventoryservice.Controller;

import com.example.inventoryservice.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping()
    public boolean isInStock(@RequestParam Long productId, @RequestParam Integer quantity) {
        return inventoryService.isInStock(productId, quantity);
    }


}
