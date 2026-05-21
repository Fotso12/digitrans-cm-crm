export interface Utilisateur {
  id?: number;
  nom: string;
  prenom: string;
  email: string;
  motDePasse?: string;
  role: string;
  actif: boolean;
  dateCreation?: Date;
  dateModification?: Date;
}
