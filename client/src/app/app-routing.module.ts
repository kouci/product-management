import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'produit',
    loadChildren: () =>
      import('./modules/produit/produit.module').then((m) => m.ProduitModule),
  },
  { path: '', redirectTo: '/produit', pathMatch: 'full' }, // Redirection vers le produit
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
