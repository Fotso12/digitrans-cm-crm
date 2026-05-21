export interface Campagne {
  id?: number;
  nom: string;
  description?: string;
  statut: string;
  dateDebut?: Date;
  dateFin?: Date;
  cibleSegment?: string;
  dateCreation?: Date;
  creeParId?: number;
}

export interface CampagneClient {
  campagneId: number;
  clientId: number;
  dateAjout?: Date;
}
