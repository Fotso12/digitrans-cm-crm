import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReclamationService } from '../../../services/reclamation.service';
import { Reclamation } from '../../../core/models/reclamation.model';

@Component({
  selector: 'app-liste-reclamations',
  imports: [RouterLink, CommonModule],
  templateUrl: './liste-reclamations.component.html',
  styleUrl: './liste-reclamations.component.scss'
})
export class ListeReclamationsComponent implements OnInit {
  reclamations: Reclamation[] = [];

  constructor(private reclamationService: ReclamationService) {}

  ngOnInit(): void {
    this.reclamationService.getAll().subscribe(data => this.reclamations = data);
  }

  delete(id: number): void {
    if (confirm('Supprimer cette réclamation ?')) {
      this.reclamationService.delete(id).subscribe(() => {
        this.reclamations = this.reclamations.filter(r => r.id !== id);
      });
    }
  }
}
