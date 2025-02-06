import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProduitListComponent } from './components/produit-list/produit-list.component';
import { ProduitDetailComponent } from './components/produit-detail/produit-detail.component';
import { ProduitFormComponent } from './components/produit-form/produit-form.component';
//import { RechercheProduitComponent } from './components/recherche-produit/recherche-produit.component';

const routes: Routes = [
  { path: '', component: ProduitListComponent }, // Liste des produits
  { path: 'ajouter', component: ProduitFormComponent }, // Formulaire d'ajout
   // { path: 'recherche', component: RechercheProduitComponent }, // Recherche
  { path: ':id', component: ProduitDetailComponent } // Détails d'un produit
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProduitRoutingModule { }
