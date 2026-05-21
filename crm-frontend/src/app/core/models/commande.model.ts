export interface Commande {
  id?: number;
  reference: string;
  statut: string;
  montantTotal: number;
  pointsAttribues: number;
  notes?: string;
  dateCommande?: Date;
  dateLivraison?: Date;
  traiteParId?: number;
  clientId: number;
  restaurantId: number;
}
