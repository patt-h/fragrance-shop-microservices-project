package com.example.orderservice.Service;

import com.example.orderservice.Client.InventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final InventoryClient inventoryClient;

    //TODO: implement logic for making new orders with user accounts, decreasing stock in inventory etc. To check if product is in stock use client above.
}
