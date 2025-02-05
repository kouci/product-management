package com.example.product_management.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.product_management.models.Categorie;
import com.example.product_management.DTOs.CategorieDTO;

@Mapper
public interface CategorieMapper {
    CategorieMapper INSTANCE = Mappers.getMapper(CategorieMapper.class);


    CategorieDTO categorieToCategorieDTO(Categorie categorie);


    Categorie categorieDTOToCategorie(CategorieDTO categorieDTO);
}
