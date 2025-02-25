import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'client';

  constructor(private router: Router) {}

  addProduct() {
    this.router.navigate(['/produit/ajouter']);  // Redirection vers /produit/ajouter
  }
}
