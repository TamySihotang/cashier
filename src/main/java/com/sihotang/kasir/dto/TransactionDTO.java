package com.sihotang.kasir.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long id;
    private LocalDateTime date;
    private Double totalAmount;
    private Long userId;
    private Long storeId;
} 