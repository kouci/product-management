package com.example.product_management.DTOs;

import com.example.product_management.models.Categorie;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CategorieDTO {

    private Long id;


    @NotNull(message = "Le nom du produit est obligatoire")
    @Size(min = 1, max = 100, message = "Le nom doit être compris entre 1 et 100 caractères")
    private String nom;



    public CategorieDTO() {}


    public CategorieDTO(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }


    public CategorieDTO(Categorie categorie) {
        this.id = categorie.getId();
        this.nom = categorie.getNom();
    }

    // Getter et Setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
