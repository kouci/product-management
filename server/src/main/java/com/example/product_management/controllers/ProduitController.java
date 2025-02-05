package com.example.product_management.controllers;

import com.example.product_management.DTOs.ProduitDTO;
import com.example.product_management.services.ProduitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@Tag(name = "Produits", description = "Gestion des produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping
    @Operation(summary = "Ajouter un nouveau produit",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Produit ajouté avec succès"),
                    @ApiResponse(responseCode = "400", description = "Erreur de validation des données du produit"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            })
    public ResponseEntity<ProduitDTO> addProduit(@Valid @RequestBody ProduitDTO produitDTO) {
        ProduitDTO newProduit = produitService.addProduit(produitDTO);
        return ResponseEntity.ok(newProduit);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un produit",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Produit mis à jour avec succès"),
                    @ApiResponse(responseCode = "404", description = "Produit non trouvé avec l'ID donné"),
                    @ApiResponse(responseCode = "400", description = "Erreur de validation des données du produit"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            })
    public ResponseEntity<ProduitDTO> updateProduit(@PathVariable Long id, @Valid @RequestBody ProduitDTO produitDTO) {
        ProduitDTO updatedProduit = produitService.updateProduit(id, produitDTO);
        return updatedProduit != null ? ResponseEntity.ok(updatedProduit) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un produit",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Produit supprimé avec succès"),
                    @ApiResponse(responseCode = "404", description = "Produit non trouvé avec l'ID donné"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            })
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les produits",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Liste des produits récupérée avec succès"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            })
    public ResponseEntity<List<ProduitDTO>> getAllProduits() {
        List<ProduitDTO> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/search")
    @Operation(summary = "Rechercher des produits", description = "Recherche des produits en fonction du nom, de la catégorie et d'une plage de prix.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Liste des produits correspondant aux critères de recherche"),
                    @ApiResponse(responseCode = "400", description = "Paramètres de recherche invalides"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            })
    public ResponseEntity<List<ProduitDTO>> searchProduits(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String categorieNom,
            @RequestParam(required = false) Double prixMin,
            @RequestParam(required = false) Double prixMax) {
        List<ProduitDTO> produits = produitService.searchProduits(nom, categorieNom, prixMin, prixMax);
        return ResponseEntity.ok(produits);
    }
}
