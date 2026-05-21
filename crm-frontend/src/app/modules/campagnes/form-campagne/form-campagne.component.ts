import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CampagneService } from '../../../services/campagne.service';
import { Campagne } from '../../../core/models/campagne.model';

@Component({
  selector: 'app-form-campagne',
  imports: [FormsModule, RouterLink],
  templateUrl: './form-campagne.component.html',
  styleUrl: './form-campagne.component.scss'
})
export class FormCampagneComponent implements OnInit {
  campagne: Campagne = {
    nom: '', statut: 'PLANIFIÉE'
  };
  isEdit = false;

  constructor(
    private campagneService: CampagneService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.campagneService.getById(Number(id)).subscribe(data => this.campagne = data);
    }
  }

  save(): void {
    if (this.isEdit) {
      this.campagneService.update(this.campagne.id!, this.campagne).subscribe(() =>
        this.router.navigate(['/campagnes'])
      );
    } else {
      this.campagneService.create(this.campagne).subscribe(() =>
        this.router.navigate(['/campagnes'])
      );
    }
  }
}
