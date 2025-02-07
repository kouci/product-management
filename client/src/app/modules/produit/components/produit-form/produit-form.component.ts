import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-produit-form',
  templateUrl: './produit-form.component.html',
  styleUrls: ['./produit-form.component.scss']
})
export class ProduitFormComponent implements OnInit {
  produitForm!: FormGroup;

  categories = [
    { label: 'Électronique', value: 'electronic' },
    { label: 'Vêtements', value: 'clothing' },
    { label: 'Meubles', value: 'furniture' }
  ];

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {

    console.log("Liste des catégories:", this.categories);
    this.produitForm = this.fb.group({
      nom: ['', Validators.required],
      description: ['', Validators.required],
      prix: ['', [Validators.required, Validators.min(0)]],
      quantite: ['', [Validators.required, Validators.min(1)]],
      categorie: [null, Validators.required]
    });
  }

  onSubmit(): void {
    if (this.produitForm.valid) {
      const produit = this.produitForm.value;
      console.log('Produit ajouté:', produit);
      // Ici, vous pouvez appeler un service pour envoyer les données au backend
    }
  }
}
