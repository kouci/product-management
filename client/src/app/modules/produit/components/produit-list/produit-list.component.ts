import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/modules/produit/services/produit.service'; // Import du service
import { Produit } from 'src/app/modules/produit/models/produit.model'; // Import du modèle (à créer)
import { CategorieService } from '../../services/categorie.service';
import { Categorie } from '../../models/categorie.model';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.scss'],
})
export class ProduitListComponent implements OnInit {
  produits: Produit[] = [];
  categories: Categorie[] = [];

  constructor(
    private produitService: ProduitService,
    private categorieService: CategorieService
  ) {}

  ngOnInit(): void {
    this.getProduits();
  }

  getProduits(): void {
    this.produitService.getProduits().subscribe(
      (produits: Produit[]) => {
        this.produits = produits;
        this.produits.forEach((produit) => {
          if (produit.categorieId) {
            this.categorieService
              .getCategorieById(produit.categorieId)
              .subscribe(
                (categorie) => {
                  produit.categorieNom = categorie.nom;
                },
                (error) => {
                  produit.categorieNom = 'Inconnu';
                }
              );
          } else {
            produit.categorieNom = 'Inconnu';
          }
        });
      },
      (error) =>
        console.error('Erreur lors de la récupération des produits', error)
    );
  }
}
