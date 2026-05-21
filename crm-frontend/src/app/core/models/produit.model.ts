export interface Produit {
  id?: number;
  nom: string;
  description?: string;
  prixUnitaire: number;
  categorie?: string;
  disponible: boolean;
  dateCreation?: Date;
}
