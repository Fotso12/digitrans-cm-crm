import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ProduitService } from '../../../services/produit.service';
import { Produit } from '../../../core/models/produit.model';

@Component({
  selector: 'app-liste-produits',
  imports: [RouterLink, CommonModule],
  templateUrl: './liste-produits.component.html',
  styleUrl: './liste-produits.component.scss'
})
export class ListeProduitsComponent implements OnInit {
  produits: Produit[] = [];

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.produitService.getAll().subscribe(data => this.produits = data);
  }

  delete(id: number): void {
    if (confirm('Supprimer ce produit ?')) {
      this.produitService.delete(id).subscribe(() => {
        this.produits = this.produits.filter(p => p.id !== id);
      });
    }
  }
}
