package com.example.product_management.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.product_management.models.Produit;
import com.example.product_management.DTOs.ProduitDTO;

@Mapper
public interface ProduitMapper {
    ProduitMapper INSTANCE = Mappers.getMapper(ProduitMapper.class);


    ProduitDTO produitToProduitDTO(Produit produit);


    Produit produitDTOToProduit(ProduitDTO produitDTO);
}
