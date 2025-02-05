package com.example.product_management.DTOs;

import com.example.product_management.models.Categorie;
import com.example.product_management.models.Produit;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


public class ProduitDTO {
    private Long id;

    @NotNull(message = "Le nom du produit est obligatoire")
    @Size(min = 1, max = 100, message = "Le nom doit être compris entre 1 et 100 caractères")
    private String nom;
    private String description;

    @NotNull(message = "Le prix du produit est obligatoire")
    private Double prix;
    private Integer quantite;
    private Categorie categorie;


    public ProduitDTO() {
    }


    public ProduitDTO(Long id, String nom, String description, Double prix, Integer quantite, Categorie categorie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
    }


    public ProduitDTO(Produit produit) {
        this.id = produit.getId();
        this.nom = produit.getNom();
        this.description = produit.getDescription();
        this.prix = produit.getPrix();
        this.quantite = produit.getQuantite();
        this.categorie = produit.getCategorie();
    }

    // Getters et Setters manuels

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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


}
