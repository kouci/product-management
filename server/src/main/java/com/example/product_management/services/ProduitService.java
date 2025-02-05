package com.example.product_management.services;

import com.example.product_management.DTOs.ProduitDTO;

import java.util.List;

public interface ProduitService {
    ProduitDTO addProduit(ProduitDTO produitDTO);

    ProduitDTO updateProduit(Long id, ProduitDTO produitDTO);

    void deleteProduit(Long id);

    List<ProduitDTO> getAllProduits();

    List<ProduitDTO> searchProduits(String nom, String categorieNom, Double prixMin, Double prixMax);
}