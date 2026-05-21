export interface Reclamation {
  id?: number;
  reference: string;
  sujet: string;
  description: string;
  statut: string;
  priorite: string;
  resolution?: string;
  dateCreation?: Date;
  dateResolution?: Date;
  dateModification?: Date;
  assigneeId?: number;
  clientId: number;
  commandeId?: number;
}
