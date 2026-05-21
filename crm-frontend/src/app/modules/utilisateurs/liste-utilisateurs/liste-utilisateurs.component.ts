import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UtilisateurService } from '../../../services/utilisateur.service';
import { Utilisateur } from '../../../core/models/utilisateur.model';

@Component({
  selector: 'app-liste-utilisateurs',
  imports: [RouterLink, CommonModule],
  templateUrl: './liste-utilisateurs.component.html',
  styleUrl: './liste-utilisateurs.component.scss'
})
export class ListeUtilisateursComponent implements OnInit {
  utilisateurs: Utilisateur[] = [];

  constructor(private utilisateurService: UtilisateurService) {}

  ngOnInit(): void {
    this.utilisateurService.getAll().subscribe(data => this.utilisateurs = data);
  }

  delete(id: number): void {
    if (confirm('Supprimer cet utilisateur ?')) {
      this.utilisateurService.delete(id).subscribe(() => {
        this.utilisateurs = this.utilisateurs.filter(u => u.id !== id);
      });
    }
  }
}
