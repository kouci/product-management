import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProduitModule } from './modules/produit/produit.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProduitService } from './modules/produit/services/produit.service';

import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { RouterModule } from '@angular/router';
import { FooterComponent } from './Shared/components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent, FooterComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ProduitModule,
    RouterModule,
    ButtonModule,
    CardModule,
  ],
  providers: [ProduitService],
  bootstrap: [AppComponent],
})
export class AppModule {}
