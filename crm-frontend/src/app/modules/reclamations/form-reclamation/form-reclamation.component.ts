import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ReclamationService } from '../../../services/reclamation.service';
import { Reclamation } from '../../../core/models/reclamation.model';

@Component({
  selector: 'app-form-reclamation',
  imports: [FormsModule, RouterLink],
  templateUrl: './form-reclamation.component.html',
  styleUrl: './form-reclamation.component.scss'
})
export class FormReclamationComponent implements OnInit {
  reclamation: Reclamation = {
    reference: '', sujet: '', description: '',
    statut: 'OUVERTE', priorite: 'MOYENNE', clientId: 0
  };
  isEdit = false;

  constructor(
    private reclamationService: ReclamationService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.reclamationService.getById(Number(id)).subscribe(data => this.reclamation = data);
    }
  }

  save(): void {
    if (this.isEdit) {
      this.reclamationService.update(this.reclamation.id!, this.reclamation).subscribe(() =>
        this.router.navigate(['/reclamations'])
      );
    } else {
      this.reclamationService.create(this.reclamation).subscribe(() =>
        this.router.navigate(['/reclamations'])
      );
    }
  }
}
