package com.sihotang.kasir.dto;

import lombok.Data;

@Data
public class StockItemDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private Long storeId;
} 