package com.example.product_management.services.impl;

import com.example.product_management.DTOs.ProduitDTO;
import com.example.product_management.models.Categorie;
import com.example.product_management.models.Produit;
import com.example.product_management.repository.CategorieRepository;
import com.example.product_management.repository.ProduitRepository;
import com.example.product_management.services.ProduitService;
import com.example.product_management.mappers.ProduitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {


    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public ProduitDTO addProduit(ProduitDTO produitDTO) {
        // Vérification du nom du produit
        if (produitDTO.getNom() == null || produitDTO.getNom().isEmpty()) {
            throw new IllegalArgumentException("Nom du produit est obligatoire");
        }


        Categorie categorie = categorieRepository.findById(produitDTO.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'ID : " + produitDTO.getCategorieId()));


        Produit produit = ProduitMapper.INSTANCE.produitDTOToProduit(produitDTO);
        produit.setCategorie(categorie);

        // Sauvegarder le produit dans la base de données
        Produit savedProduit = produitRepository.save(produit);

        // Retourner le produit sauvegardé sous forme de DTO
        return ProduitMapper.INSTANCE.produitToProduitDTO(savedProduit);
    }


    @Override
    public ProduitDTO updateProduit(Long id, ProduitDTO produitDTO) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit != null) {

            produit.setNom(produitDTO.getNom());
            produit.setDescription(produitDTO.getDescription());
            produit.setPrix(produitDTO.getPrix());
            produit.setQuantite(produitDTO.getQuantite());


            if (produitDTO.getCategorieId() != null) {
                Categorie categorie = categorieRepository.findById(produitDTO.getCategorieId())
                        .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'ID : " + produitDTO.getCategorieId()));
                produit.setCategorie(categorie);
            }


            Produit updatedProduit = produitRepository.save(produit);


            return ProduitMapper.INSTANCE.produitToProduitDTO(updatedProduit);
        }
        return null;
    }


    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public List<ProduitDTO> getAllProduits() {
        return produitRepository.findAll().stream()
                .map(produit -> {
                    ProduitDTO produitDTO = ProduitMapper.INSTANCE.produitToProduitDTO(produit);
                    return produitDTO;
                })
                .collect(Collectors.toList());
    }


    @Override
    public ProduitDTO getProduitById(Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'ID : " + id));

        return ProduitMapper.INSTANCE.produitToProduitDTO(produit);
    }

    @Override
    public List<ProduitDTO> searchProduits(String nom, String categorieNom, Double prixMin, Double prixMax) {
        // ajout des logs pour déboguer
        System.out.println("Recherche produit - nom: " + nom + ", catégorie: " + categorieNom + ", prix min: " + prixMin + ", prix max: " + prixMax);

        return produitRepository.searchByCriteria(nom, categorieNom, prixMin, prixMax)
                .stream()
                .map(ProduitMapper.INSTANCE::produitToProduitDTO)
                .collect(Collectors.toList());
    }
}
