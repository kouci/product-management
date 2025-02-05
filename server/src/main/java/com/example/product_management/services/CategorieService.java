package com.example.product_management.services;

import com.example.product_management.DTOs.CategorieDTO;

import java.util.List;

public interface CategorieService {
    CategorieDTO addCategorie(CategorieDTO categorieDTO);

    CategorieDTO updateCategorie(Long id, CategorieDTO categorieDTO);

    void deleteCategorie(Long id);

    List<CategorieDTO> getAllCategories();
}
