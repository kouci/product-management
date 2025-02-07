import { Component } from '@angular/core';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.scss']
})
export class ProduitListComponent {
  
  produits = [
    { nom: 'Ordinateur Portable', description: 'PC Gamer ultra performant', prix: 1200, quantite: 5 },
    { nom: 'Smartphone', description: 'Écran AMOLED 120Hz', prix: 799, quantite: 10 },
    { nom: 'Casque Bluetooth', description: 'Réduction de bruit active', prix: 199, quantite: 15 }
  ];
}
