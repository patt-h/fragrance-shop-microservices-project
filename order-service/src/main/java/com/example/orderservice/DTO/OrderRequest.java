package com.example.orderservice.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<OrderProductRequest> products;
}
