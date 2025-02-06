import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProduitRoutingModule } from './produit-routing.module';
import { ProduitListComponent } from './components/produit-list/produit-list.component';
import { ProduitDetailComponent } from './components/produit-detail/produit-detail.component';
import { ProduitFormComponent } from './components/produit-form/produit-form.component';
import { ProduitSearchComponent } from './components/produit-search/produit-search.component';


@NgModule({
  declarations: [
    ProduitListComponent,
    ProduitDetailComponent,
    ProduitFormComponent,
    ProduitSearchComponent
  ],
  imports: [
    CommonModule,
    ProduitRoutingModule
  ]
})
export class ProduitModule { }
