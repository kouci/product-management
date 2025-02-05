package com.example.product_management.services.impl;

import com.example.product_management.DTOs.CategorieDTO;
import com.example.product_management.models.Categorie;
import com.example.product_management.repository.CategorieRepository;
import com.example.product_management.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public CategorieDTO addCategorie(CategorieDTO categorieDTO) {

        if (categorieDTO.getNom() == null || categorieDTO.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la catégorie est obligatoire.");
        }


        Categorie categorie = new Categorie();
        categorie.setNom(categorieDTO.getNom());

        // Sauvegarde de la catégorie dans la base de données
        Categorie savedCategorie = categorieRepository.save(categorie);

        // Retourne le DTO de la catégorie sauvegardée
        return new CategorieDTO(savedCategorie);
    }

    @Override
    public CategorieDTO updateCategorie(Long id, CategorieDTO categorieDTO) {
        // Recherche de la catégorie par son ID
        Categorie categorie = categorieRepository.findById(id).orElse(null);
        if (categorie == null) {
            throw new IllegalArgumentException("Catégorie non trouvée avec l'ID: " + id);
        }


        categorie.setNom(categorieDTO.getNom());



        Categorie updatedCategorie = categorieRepository.save(categorie);


        return new CategorieDTO(updatedCategorie);
    }

    @Override
    public void deleteCategorie(Long id) {

        if (!categorieRepository.existsById(id)) {
            throw new IllegalArgumentException("Catégorie non trouvée avec l'ID: " + id);
        }

        // Suppression de la catégorie
        categorieRepository.deleteById(id);
    }

    @Override
    public List<CategorieDTO> getAllCategories() {

        return categorieRepository.findAll()
                .stream()
                .map(CategorieDTO::new)
                .collect(Collectors.toList());
    }
}