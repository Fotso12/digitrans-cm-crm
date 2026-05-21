import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommandeService } from '../../../services/commande.service';
import { Commande } from '../../../core/models/commande.model';

@Component({
  selector: 'app-form-commande',
  imports: [FormsModule, RouterLink],
  templateUrl: './form-commande.component.html',
  styleUrl: './form-commande.component.scss'
})
export class FormCommandeComponent implements OnInit {
  commande: Commande = {
    reference: '', statut: 'EN_ATTENTE', montantTotal: 0,
    pointsAttribues: 0, clientId: 0, restaurantId: 0
  };
  isEdit = false;

  constructor(
    private commandeService: CommandeService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.commandeService.getById(Number(id)).subscribe(data => this.commande = data);
    }
  }

  save(): void {
    if (this.isEdit) {
      this.commandeService.update(this.commande.id!, this.commande).subscribe(() =>
        this.router.navigate(['/commandes'])
      );
    } else {
      this.commandeService.create(this.commande).subscribe(() =>
        this.router.navigate(['/commandes'])
      );
    }
  }
}
