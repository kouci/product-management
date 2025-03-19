package com.example.product_management.services;

import com.example.product_management.DTOs.CategorieDTO;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    CategorieDTO addCategorie(CategorieDTO categorieDTO);

    CategorieDTO updateCategorie(Long id, CategorieDTO categorieDTO);

    void deleteCategorie(Long id);

    CategorieDTO getCategorieById(Long id);
    List<CategorieDTO> getAllCategories();
}
