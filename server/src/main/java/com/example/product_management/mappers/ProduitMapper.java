package com.example.product_management.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.product_management.models.Produit;
import com.example.product_management.DTOs.ProduitDTO;

@Mapper
public interface ProduitMapper {
    ProduitMapper INSTANCE = Mappers.getMapper(ProduitMapper.class);

    // Mapper Produit vers ProduitDTO
    ProduitDTO produitToProduitDTO(Produit produit);

    // Mapper ProduitDTO vers Produit
    Produit produitDTOToProduit(ProduitDTO produitDTO);
}
