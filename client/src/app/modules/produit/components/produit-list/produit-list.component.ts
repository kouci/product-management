import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/modules/produit/services/produit.service'; // Import du service
import { Produit } from 'src/app/modules/produit/models/produit.model'; // Import du modèle (à créer)

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.scss'],
})
export class ProduitListComponent implements OnInit {
  produits: Produit[] = [];

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.getProduits();
  }

  getProduits(): void {
    this.produitService.getProduits().subscribe(
      (produits: Produit[]) => {
        this.produits = produits;
      },
      (error) => {
        console.error('Erreur lors de la récupération des produits', error);
      }
    );
  }
}
