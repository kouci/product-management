import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProduitRoutingModule } from './produit-routing.module';
import { ProduitListComponent } from './components/produit-list/produit-list.component';
import { ProduitDetailComponent } from './components/produit-detail/produit-detail.component';
import { ProduitFormComponent } from './components/produit-form/produit-form.component';
import { ProduitSearchComponent } from './components/produit-search/produit-search.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DropdownModule } from 'primeng/dropdown';

import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';

import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { ProduitService } from './services/produit.service';
import { CarouselModule } from 'primeng/carousel';

@NgModule({
  declarations: [
    ProduitListComponent,
    ProduitDetailComponent,
    ProduitFormComponent,
    ProduitSearchComponent,
  ],
  imports: [
    CommonModule,
    ProduitRoutingModule,
    CardModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    InputTextModule,
    DropdownModule,
    CarouselModule,
    TableModule,
  ],
  providers: [ProduitService],
  exports: [ProduitListComponent, ProduitFormComponent, ProduitDetailComponent],
})
export class ProduitModule {}
