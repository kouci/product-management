import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CategorieService } from '../../services/categorie.service';
import { Produit } from '../../models/produit.model';
import { ProduitService } from '../../services/produit.service';
import { MessageService } from 'primeng/api'; // Import de MessageService

@Component({
  selector: 'app-produit-form',
  templateUrl: './produit-form.component.html',
  styleUrls: ['./produit-form.component.scss'],
  providers: [MessageService] // Fournisseur de MessageService
})
export class ProduitFormComponent implements OnInit {
  produitForm!: FormGroup;
  categories: any[] = [];

  constructor(
    private fb: FormBuilder,
    private categorieService: CategorieService,
    private produitService: ProduitService,
    private messageService: MessageService // Injection du MessageService
  ) {}

  ngOnInit(): void {
    // Récupérer les catégories du backend
    this.categorieService.getAllCategories().subscribe(
      (categories) => {
        console.log("Liste des catégories:", categories);
        this.categories = categories.map((categorie) => ({
          label: categorie.nom, // Le nom de la catégorie depuis le backend
          value: categorie.id    // L'ID de la catégorie
        }));
      },
      (error) => {
        console.error("Erreur lors de la récupération des catégories", error);
      }
    );

    // Initialisation du formulaire
    this.produitForm = this.fb.group({
      nom: ['', Validators.required],
      description: ['', Validators.required],
      prix: ['', [Validators.required, Validators.min(0)]],
      quantite: ['', [Validators.required, Validators.min(1)]],
      categorieId: [null, Validators.required] // ID de la catégorie sélectionnée
    });
  }

  onSubmit(): void {
    if (this.produitForm.valid) {
      const produit: Produit = this.produitForm.value;
      console.log('Produit à ajouter:', produit);
      // Appeler le service pour ajouter le produit
      this.produitService.addProduit(produit).subscribe(
        (response) => {
        
          this.messageService.add({
            severity: 'success',
            summary: 'Succès',
            detail: 'Produit créé avec succès!'
          });

          // Réinitialiser le formulaire
          this.produitForm.reset();
        },
        (error) => {
          console.error('Erreur lors de l\'ajout du produit:', error);
          // Afficher un toast d'erreur
          this.messageService.add({
            severity: 'error',
            summary: 'Erreur',
            detail: 'Erreur lors de la création du produit.'
          });
        }
      );
    }
  }
}
