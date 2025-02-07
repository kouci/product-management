import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProduitListComponent } from './components/produit-list/produit-list.component';
import { ProduitFormComponent } from './components/produit-form/produit-form.component';
import { ProduitDetailComponent } from './components/produit-detail/produit-detail.component';

const routes: Routes = [
  { path: '', component: ProduitListComponent }, // Liste des produits
  { path: 'ajouter', component: ProduitFormComponent }, // Formulaire d'ajout produit
  { path: 'produit/detail/:id', component: ProduitDetailComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProduitRoutingModule { }
