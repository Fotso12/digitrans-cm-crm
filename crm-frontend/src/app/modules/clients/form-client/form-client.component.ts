import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../core/models/client.model';

@Component({
  selector: 'app-form-client',
  imports: [FormsModule, RouterLink],
  templateUrl: './form-client.component.html',
  styleUrl: './form-client.component.scss'
})
export class FormClientComponent implements OnInit {
  client: Client = {
    nom: '', prenom: '', telephone: '', pointsFidelite: 0,
    niveauFidelite: 'BRONZE', statut: 'ACTIF'
  };
  isEdit = false;

  constructor(
    private clientService: ClientService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.clientService.getById(Number(id)).subscribe(data => this.client = data);
    }
  }

  save(): void {
    if (this.isEdit) {
      this.clientService.update(this.client.id!, this.client).subscribe(() =>
        this.router.navigate(['/clients', this.client.id])
      );
    } else {
      this.clientService.create(this.client).subscribe(() =>
        this.router.navigate(['/clients'])
      );
    }
  }
}
