import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ProduitService } from '../../../services/produit.service';
import { Produit } from '../../../core/models/produit.model';

@Component({
  selector: 'app-form-produit',
  imports: [FormsModule, RouterLink],
  templateUrl: './form-produit.component.html',
  styleUrl: './form-produit.component.scss'
})
export class FormProduitComponent implements OnInit {
  produit: Produit = {
    nom: '', prixUnitaire: 0, disponible: true
  };
  isEdit = false;

  constructor(
    private produitService: ProduitService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.produitService.getById(Number(id)).subscribe(data => this.produit = data);
    }
  }

  save(): void {
    if (this.isEdit) {
      this.produitService.update(this.produit.id!, this.produit).subscribe(() =>
        this.router.navigate(['/produits'])
      );
    } else {
      this.produitService.create(this.produit).subscribe(() =>
        this.router.navigate(['/produits'])
      );
    }
  }
}
