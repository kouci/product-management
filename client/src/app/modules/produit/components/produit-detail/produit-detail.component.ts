import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProduitService } from 'src/app/modules/produit/services/produit.service'; // Import du service
import { Produit } from 'src/app/modules/produit/models/produit.model'; // Import du modèle

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.scss'],
})
export class ProduitDetailComponent implements OnInit {
  produit: Produit | undefined; // Produit à afficher
  id: number | null = null; // ID du produit à récupérer, type 'number' maintenant

  constructor(
    private route: ActivatedRoute, // Pour récupérer l'ID de l'URL
    private produitService: ProduitService // Service pour récupérer le produit
  ) {}

  ngOnInit(): void {
    // Récupération de l'ID depuis l'URL et conversion en nombre
    const idStr = this.route.snapshot.paramMap.get('id');
    if (idStr) {
      this.id = Number(idStr); // Conversion de l'ID en nombre
      if (this.id) {
        this.getProduitDetail(this.id); // Appel de la méthode pour récupérer le produit
      }
    }
  }

  // Méthode pour récupérer les détails du produit
  getProduitDetail(id: number): void {
    this.produitService.getProduitById(id).subscribe(
      (produit: Produit) => {
        this.produit = produit; // Affectation du produit récupéré
      },
      (error) => {
        console.error('Erreur lors de la récupération du produit', error);
      }
    );
  }
}
