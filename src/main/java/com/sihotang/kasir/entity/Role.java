package com.sihotang.kasir.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
} 