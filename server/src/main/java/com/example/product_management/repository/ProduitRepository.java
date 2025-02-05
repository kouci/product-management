package com.example.product_management.repository;

import com.example.product_management.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    // Recherche par nom et par catégorie (si les deux sont fournis)
    @Query("SELECT p FROM Produit p WHERE "
            + "(LOWER(p.nom) LIKE LOWER(CONCAT('%', :nom, '%')) OR :nom IS NULL) "
            + "AND (LOWER(p.categorie.nom) LIKE LOWER(CONCAT('%', :categorieNom, '%')) OR :categorieNom IS NULL) "
            + "AND (p.prix BETWEEN :prixMin AND :prixMax OR (:prixMin IS NULL AND :prixMax IS NULL))")
    List<Produit> searchByCriteria(@Param("nom") String nom,
                                   @Param("categorieNom") String categorieNom,
                                   @Param("prixMin") Double prixMin,
                                   @Param("prixMax") Double prixMax);
}