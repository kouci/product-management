package com.example.product_management.controllers;

import com.example.product_management.DTOs.CategorieDTO;
import com.example.product_management.models.Categorie;
import com.example.product_management.repository.CategorieRepository;
import com.example.product_management.services.CategorieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Catégories", description = "Gestion des catégories de produits")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private CategorieRepository categorieRepository;

    @PostMapping
    @Operation(summary = "Ajouter une nouvelle catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide, les données de la catégorie sont manquantes ou incorrectes"),
            @ApiResponse(responseCode = "409", description = "Une catégorie avec ce nom existe déjà")
    })
    public ResponseEntity<CategorieDTO> addCategorie(@Valid @RequestBody CategorieDTO categorieDTO) {
        try {
            CategorieDTO newCategorie = categorieService.addCategorie(categorieDTO);
            return ResponseEntity.ok(newCategorie);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie mise à jour avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide, données incorrectes"),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée")
    })
    public ResponseEntity<CategorieDTO> updateCategorie(@PathVariable Long id, @Valid @RequestBody CategorieDTO categorieDTO) {
        try {
            CategorieDTO updatedCategorie = categorieService.updateCategorie(id, categorieDTO);
            return ResponseEntity.ok(updatedCategorie);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Catégorie supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée")
    })
    public ResponseEntity<Void> deleteCategorie(@PathVariable Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);

        if (categorie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            categorieService.deleteCategorie(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public CategorieDTO getCategorieById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }

    @GetMapping
    @Operation(summary = "Récupérer toutes les catégories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des catégories récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    public ResponseEntity<List<CategorieDTO>> getAllCategories() {
        try {
            List<CategorieDTO> categories = categorieService.getAllCategories();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
