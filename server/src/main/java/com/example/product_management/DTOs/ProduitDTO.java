package com.example.product_management.DTOs;

import com.example.product_management.models.Categorie;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProduitDTO {
    private Long id;
    private String nom;
    private String description;
    private Double prix;
    private Integer quantite;
    private Long categorieId;  // Seulement l'ID de la catégorie

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
}


