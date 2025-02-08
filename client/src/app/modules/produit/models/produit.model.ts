export interface Produit {
  id: number;
  nom: string;
  prix: number;
  quantite: number;
  description: string;
  categorieId: number;
  categorieNom?: string;
}
