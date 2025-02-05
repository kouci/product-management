package com.example.product_management.services.impl;

import com.example.product_management.DTOs.CategorieDTO;
import com.example.product_management.models.Categorie;
import com.example.product_management.repository.CategorieRepository;
import com.example.product_management.services.CategorieService;
import com.example.product_management.mappers.CategorieMapper;  // Import du mapper
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        // Vérification si une catégorie avec le même nom existe déjà
        Optional<Categorie> existingCategorie = categorieRepository.findByNom(categorieDTO.getNom());
        if (existingCategorie.isPresent()) {
            throw new IllegalArgumentException("Une catégorie avec ce nom existe déjà.");
        }


        Categorie categorie = CategorieMapper.INSTANCE.categorieDTOToCategorie(categorieDTO);



        Categorie savedCategorie = categorieRepository.save(categorie);


        return CategorieMapper.INSTANCE.categorieToCategorieDTO(savedCategorie);
    }

    @Override
    public CategorieDTO updateCategorie(Long id, CategorieDTO categorieDTO) {
        // Recherche de la catégorie par son ID
        Categorie categorie = categorieRepository.findById(id).orElse(null);
        if (categorie == null) {
            throw new IllegalArgumentException("Catégorie non trouvée avec l'ID: " + id);
        }

        // Recharger l'entité à partir de la base de données pour s'assurer qu'elle n'a pas été modifiée
        Categorie reloadedCategorie = categorieRepository.findById(id).orElse(null);
        if (reloadedCategorie == null) {
            throw new IllegalArgumentException("Catégorie non trouvée avec l'ID: " + id);
        }

        // Mettre à jour les valeurs de la catégorie avec les données du DTO
        reloadedCategorie.setNom(categorieDTO.getNom());

        // Sauvegarder les modifications
        Categorie updatedCategorie = categorieRepository.save(reloadedCategorie);

        // Retourner l'entité mise à jour sous forme de DTO
        return CategorieMapper.INSTANCE.categorieToCategorieDTO(updatedCategorie);
    }


    @Override
    public void deleteCategorie(Long id) {
        if (!categorieRepository.existsById(id)) {
            throw new IllegalArgumentException("Catégorie non trouvée avec l'ID: " + id);
        }


        categorieRepository.deleteById(id);
    }

    @Override
    public List<CategorieDTO> getAllCategories() {

        return categorieRepository.findAll()
                .stream()
                .map(CategorieMapper.INSTANCE::categorieToCategorieDTO)
                .collect(Collectors.toList());
    }
}
