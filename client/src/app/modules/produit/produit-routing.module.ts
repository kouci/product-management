import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProduitListComponent } from './components/produit-list/produit-list.component';
import { ProduitFormComponent } from './components/produit-form/produit-form.component';

const routes: Routes = [
  { path: '', component: ProduitListComponent }, // Liste des produits
  { path: 'ajouter', component: ProduitFormComponent }, // Formulaire d'ajout produit
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProduitRoutingModule { }
