-- V1__Add_date_creation_column_to_produit.sql

-- Ajouter la colonne date_creation à la table produit
ALTER TABLE produit
    ADD COLUMN date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP;


UPDATE produit
SET date_creation = CURRENT_TIMESTAMP
WHERE date_creation IS NULL;


