package com.example.product_management.DTOs;

import com.example.product_management.models.Categorie;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {
    private Long id;
    private String nom;
    private String description;
    private Double prix;
    private Integer quantité;
    private CategorieDTO categorie;
}