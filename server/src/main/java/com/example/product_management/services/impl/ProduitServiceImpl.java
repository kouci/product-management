package com.example.product_management.services.impl;


import com.example.product_management.DTOs.ProduitDTO;
import com.example.product_management.models.Produit;
import com.example.product_management.repository.ProduitRepository;
import com.example.product_management.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public ProduitDTO addProduit(ProduitDTO produitDTO) {
        if (produitDTO.getNom() == null || produitDTO.getNom().isEmpty()) {
            throw new IllegalArgumentException("Nom du produit est obligatoire");
        }
        Produit produit = new Produit();
        produit.setNom(produitDTO.getNom());
        produit.setDescription(produitDTO.getDescription());
        produit.setPrix(produitDTO.getPrix());
        produit.setQuantite(produitDTO.getQuantite());
        produit.setCategorie(produitDTO.getCategorie());

        Produit savedProduit = produitRepository.save(produit);
        return new ProduitDTO(savedProduit);
    }

    @Override
    public ProduitDTO updateProduit(Long id, ProduitDTO produitDTO) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit != null) {
            produit.setNom(produitDTO.getNom());
            produit.setDescription(produitDTO.getDescription());
            produit.setPrix(produitDTO.getPrix());
            produit.setQuantite(produitDTO.getQuantite());
            produit.setCategorie(produitDTO.getCategorie());
            Produit updatedProduit = produitRepository.save(produit);
            return new ProduitDTO(updatedProduit);
        }
        return null;
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public List<ProduitDTO> getAllProduits() {
        return produitRepository.findAll()
                .stream()
                .map(ProduitDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProduitDTO> searchProduits(String nom, String categorieNom, Double prixMin, Double prixMax) {
        return produitRepository.searchByCriteria(nom, categorieNom, prixMin, prixMax)
                .stream()
                .map(ProduitDTO::new)
                .collect(Collectors.toList());
    }
}