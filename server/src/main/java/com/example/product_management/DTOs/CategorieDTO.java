package com.example.product_management.DTOs;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieDTO {
    private Long id;
    private String nom;
}