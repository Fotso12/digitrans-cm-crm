import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CommandeService } from '../../../services/commande.service';
import { Commande } from '../../../core/models/commande.model';

@Component({
  selector: 'app-liste-commandes',
  imports: [RouterLink, CommonModule],
  templateUrl: './liste-commandes.component.html',
  styleUrl: './liste-commandes.component.scss'
})
export class ListeCommandesComponent implements OnInit {
  commandes: Commande[] = [];

  constructor(private commandeService: CommandeService) {}

  ngOnInit(): void {
    this.commandeService.getAll().subscribe(data => this.commandes = data);
  }

  delete(id: number): void {
    if (confirm('Supprimer cette commande ?')) {
      this.commandeService.delete(id).subscribe(() => {
        this.commandes = this.commandes.filter(c => c.id !== id);
      });
    }
  }
}
