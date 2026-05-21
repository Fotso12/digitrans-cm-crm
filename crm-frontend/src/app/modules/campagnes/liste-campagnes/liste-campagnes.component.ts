import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CampagneService } from '../../../services/campagne.service';
import { Campagne } from '../../../core/models/campagne.model';

@Component({
  selector: 'app-liste-campagnes',
  imports: [RouterLink, CommonModule],
  templateUrl: './liste-campagnes.component.html',
  styleUrl: './liste-campagnes.component.scss'
})
export class ListeCampagnesComponent implements OnInit {
  campagnes: Campagne[] = [];

  constructor(private campagneService: CampagneService) {}

  ngOnInit(): void {
    this.campagneService.getAll().subscribe(data => this.campagnes = data);
  }

  delete(id: number): void {
    if (confirm('Supprimer cette campagne ?')) {
      this.campagneService.delete(id).subscribe(() => {
        this.campagnes = this.campagnes.filter(c => c.id !== id);
      });
    }
  }
}
