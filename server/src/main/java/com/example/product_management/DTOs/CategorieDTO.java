package com.example.product_management.DTOs;

import com.example.product_management.models.Categorie;
import lombok.Getter;
import lombok.Setter;

public class CategorieDTO {

    private Long id;

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
