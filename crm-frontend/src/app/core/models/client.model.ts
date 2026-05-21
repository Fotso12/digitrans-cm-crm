export interface Client {
  id?: number;
  nom: string;
  prenom: string;
  email?: string;
  telephone: string;
  dateNaissance?: Date;
  adresse?: string;
  ville?: string;
  pointsFidelite: number;
  niveauFidelite: string;
  statut: string;
  dateInscription?: Date;
  dateModification?: Date;
  restaurantHabituelId?: number;
  creeParId?: number;
}
